package com.learning.poc.processor;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class RestResponseProcessor implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String payload = eventContext.getMessage().getPayloadAsString();
		System.out.println("\n\n\t\tPayload from REST service is: " + payload + "\n\n");
		return eventContext.getMessage();
	}
}
