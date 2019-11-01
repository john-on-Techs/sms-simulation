package com.creativityskills.mdb;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

@JMSDestinationDefinitions(
        value = {
                @JMSDestinationDefinition(
                        name = MessageQueueDefinition.MESSAGE_QUEUE,
                        interfaceName = "javax.jms.Queue",
                        destinationName = "message-queue"
                ),
                @JMSDestinationDefinition(
                        name = MessageQueueDefinition.MESSAGE_TOPIC,
                        interfaceName = "javax.jms.Topic",
                        destinationName = "message-topic"
                )
        }
)

@Stateless
@Startup
public class MessageQueueDefinition {
    public static final String MESSAGE_QUEUE = "java:/jms/queue/message-queue";
    public static final String MESSAGE_TOPIC = "java:/jms/topic/message-topic";
}
