package entity;

public class User {
	
	private String sessionIdString;
	
	private String ipString;
	
	private String firstTime;
	
	

	public User() {
	}

	public String getSessionIdString() {
		return sessionIdString;
	}

	public void setSessionIdString(String sessionIdString) {
		this.sessionIdString = sessionIdString;
	}

	public String getIpString() {
		return ipString;
	}

	public void setIpString(String ipString) {
		this.ipString = ipString;
	}

	public String getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	
	
}
