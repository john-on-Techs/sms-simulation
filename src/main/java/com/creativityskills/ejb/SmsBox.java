package com.creativityskills.ejb;

import com.creativityskills.mdb.MessageQueueProducer;
import com.creativityskills.model.MessageStatus;
import com.creativityskills.model.TextMessage;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

@Singleton
@Local
public class SmsBox implements SmsBoxI{
    @Inject
    private Logger logger;

    private Queue<TextMessage> messageQueue;
    @Inject
    private MessageQueueProducer messageQueueProducer;

    @PostConstruct
    public void setup(){
        messageQueue = new LinkedList<>();
        TextMessage textMessage = new TextMessage();
        textMessage.setBody("Hello");
        textMessage.setRecipient("0700596314");
        textMessage.setSender("0706341528");

        logger.info("Queue constructed");
    }
    @Override
    public void addMessage(TextMessage textMessage){
        messageQueue.add(textMessage);
    }
    @Override
    public TextMessage removeMessage(){

        return messageQueue.poll();
    }
    @Schedule(second = "*/1",minute = "*",hour = "*")
    @Override
    public void sendMessage() {
        Stream<TextMessage> messageStream = messageQueue.stream()
                .filter((x)-> ChronoUnit.HOURS.between( x.getCreated_time().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime(), LocalDateTime.now())>24 &&
                 x.getSentStatus().equals(MessageStatus.PENDING));
        messageStream.forEach((x)->messageQueueProducer.sendMessage(x.toString()));



    }

    @Override
    public Queue<TextMessage> getMessages(){
        return messageQueue;
    }





}
