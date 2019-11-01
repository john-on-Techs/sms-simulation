package com.creativityskills.service;

import com.creativityskills.model.TextMessage;

import javax.ejb.Local;

@Local
public interface SmsGateway {
    boolean sendMessage(TextMessage textMessage);
}
