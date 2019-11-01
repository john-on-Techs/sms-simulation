package com.creativityskills.service;

import com.creativityskills.model.TextMessage;
import com.creativityskills.qualifier.SmsProvider;

@SmsProvider(SmsProvider.Lang.ADVANTA)
public class Advanta implements SmsGateway {


    @Override
    public boolean sendMessage(TextMessage textMessage) {
        return true;
      }

}

