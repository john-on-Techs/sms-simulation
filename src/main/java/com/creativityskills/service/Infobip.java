package com.creativityskills.service;

import com.creativityskills.mdb.MessageQueueProducer;
import com.creativityskills.model.TextMessage;
import com.creativityskills.qualifier.SmsProvider;

import javax.inject.Inject;

@SmsProvider(SmsProvider.Lang.INFOBIP)
public class Infobip implements SmsGateway {
    @Inject
    private MessageQueueProducer messageQueueProducer;

    @Override
    public boolean sendMessage(TextMessage textMessage) {
        return true;
    }
}
