package org.melon.ws.server;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(UserAdapter.class)
public interface User {
	
	String getName();
	
}
