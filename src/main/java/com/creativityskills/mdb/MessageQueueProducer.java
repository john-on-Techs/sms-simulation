package com.creativityskills.mdb;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@ApplicationScoped
public class MessageQueueProducer {
    @Inject
    private JMSContext context;
    @Inject
    private MessageCompletionListener messageCompletionListener;
    @Resource(mappedName = MessageQueueDefinition.MESSAGE_QUEUE)
    private Queue syncQueue;


    public void sendMessage(String txt) {
        context.createProducer()
                .setAsync(messageCompletionListener)
                .send(syncQueue, txt);
    }
}