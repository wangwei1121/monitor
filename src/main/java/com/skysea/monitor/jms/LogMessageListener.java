package com.skysea.monitor.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.event.LoggingEvent;

public class LogMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("###########" + message.getJMSType());
			// receive log event in your consumer
			LoggingEvent event = (LoggingEvent) ((ActiveMQObjectMessage) message).getObject();
			System.out.println("Logging project: [" + event.getLevel() + "]: " + event.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
