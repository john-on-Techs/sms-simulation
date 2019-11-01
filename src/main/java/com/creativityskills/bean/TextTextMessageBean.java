package com.creativityskills.bean;

import com.creativityskills.model.TextMessage;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;


@Stateless
@Local
public class TextTextMessageBean extends Bean<TextMessage> implements TextMessageBeanI {
    @PostConstruct
    public  void setup(){
        this.entityClass= TextMessage.class;
    }

}
