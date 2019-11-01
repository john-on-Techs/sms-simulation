package com.creativityskills.service;

import com.creativityskills.ejb.SmsBoxI;
import com.creativityskills.mdb.MessageQueueProducer;
import com.creativityskills.model.TextMessage;
import com.creativityskills.qualifier.SmsProvider;

import javax.ejb.EJB;
import javax.inject.Inject;

@SmsProvider(SmsProvider.Lang.AFRICASTALKING)
public class AfricasTalking implements SmsGateway {
    @EJB
    private SmsBoxI smsBoxI;
    @Override
    public boolean sendMessage(TextMessage textMessage) {
        smsBoxI.addMessage(textMessage);
        return true;
    }
}
