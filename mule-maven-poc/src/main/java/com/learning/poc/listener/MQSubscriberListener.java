package com.learning.poc.listener;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class MQSubscriberListener implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		System.out.println("\n\n\t\t Message received from queue is: " + eventContext.getMessage().getPayloadAsString() + "\n\n");
		return eventContext.getMessage().getPayloadAsString();
	}

}
