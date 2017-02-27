package validator;

import java.util.Map;


import org.mule.api.MuleMessage;
import org.mule.api.routing.filter.Filter;

public class InputDataValidator implements Filter {

	@Override
	public boolean accept(MuleMessage message) {

		Map<String, Object> payloadMap = (Map<String, Object>) message.getPayload();
		
		if(!payloadMap.containsKey("email")){
			throw new NullPointerException("Email is Missing \n" + payloadMap.toString());
		}else if(Integer.parseInt(payloadMap.get("id").toString()) < 0){ 
			throw new IllegalArgumentException("emp id should be greater than 0 \n" + payloadMap.toString());
		}else if(payloadMap.get("contactNo").toString().length() < 10){
			throw new IllegalArgumentException("invalid mobile number \n" + payloadMap.toString());	
		}
		return true;
	}

}
