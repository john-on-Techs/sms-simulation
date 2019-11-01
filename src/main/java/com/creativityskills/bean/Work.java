package com.creativityskills.bean;

import com.creativityskills.model.TextMessage;
import com.creativityskills.qualifier.SmsProvider;
import com.creativityskills.service.SmsGateway;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.Queue;

public class Work {
    @Inject
    @SmsProvider(SmsProvider.Lang.NEXMO)
    private SmsGateway smsGateway;




}
