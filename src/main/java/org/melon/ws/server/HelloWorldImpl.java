package org.melon.ws.server;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.jws.WebService;

import org.apache.log4j.Logger;

@WebService(endpointInterface = "org.melon.ws.server.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	
	private final Logger log = Logger.getLogger(getClass());
	
	Map<Integer, User> users = new LinkedHashMap<Integer, User>();

	@Override
	public String sayHi(String text) {
		log.info("sayHi called");
        return "Hello " + text;
	}

	@Override
	public String sayHiToUser(User user) {
		log.info("sayHiToUser called");
        users.put(users.size() + 1, user);
        return "Hello "  + user.getName();
	}

	@Override
	public Map<Integer, User> getUsers() {
		log.info("getUsers called");
        return users;
	}

}
