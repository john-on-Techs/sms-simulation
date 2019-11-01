package com.creativityskills.qualifier;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.TYPE})
public @interface SmsProvider {
    enum Lang{
        AFRICASTALKING,
        NEXMO,
        INFOBIP,
        ADVANTA,
    }
    Lang value();
}