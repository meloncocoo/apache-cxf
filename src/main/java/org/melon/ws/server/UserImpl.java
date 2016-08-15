package org.melon.ws.server;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "User")
public class UserImpl implements User {
	
	private String name;
	
	public UserImpl() {
		
	}
	
	public UserImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
