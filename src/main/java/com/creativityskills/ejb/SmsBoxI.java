package com.creativityskills.ejb;

import com.creativityskills.model.TextMessage;


import javax.ejb.Local;
import java.util.Queue;

@Local
public interface SmsBoxI {
    void addMessage(TextMessage textMessage);
    TextMessage removeMessage();
    void sendMessage();
    Queue<TextMessage> getMessages();

}
