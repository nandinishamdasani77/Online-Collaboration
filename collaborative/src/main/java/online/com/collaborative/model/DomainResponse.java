package online.com.collaborative.model;

public class DomainResponse {

	private String responseMessage;
	private int responseCode;
	
	public DomainResponse(){
}
public DomainResponse(String responseMessage,int responseCode)
{
	super();
	this.responseMessage=responseMessage;
	this.responseCode=responseCode;
	
}
public String getResponseMessage() {
	return responseMessage;
}
public void setResponseMessage(String responseMessage) {
	this.responseMessage = responseMessage;
}
public int getResponseCode() {
	return responseCode;
}
public void setResponseCode(int responseCode) {
	this.responseCode = responseCode;
}
}
