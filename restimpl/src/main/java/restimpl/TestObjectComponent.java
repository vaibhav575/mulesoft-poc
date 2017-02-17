package restimpl;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class TestObjectComponent implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		
		Employee emp = new Employee(1, "vaibhav", "P", "9890098900", "Pune");
		
		message.setPayload(emp);
		return message;
	}


}
