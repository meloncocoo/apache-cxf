package org.melon.ws.client;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.log4j.Logger;
import org.melon.ws.server.HelloWorld;
import org.melon.ws.server.User;
import org.melon.ws.server.UserImpl;

public class Client {

	private static final Logger log = Logger.getLogger(Client.class);
	
    private static final QName SERVICE_NAME = new QName("http://server.ws.melon.org/", "HelloWorld");
    private static final QName PORT_NAME = new QName("http://server.ws.melon.org/", "HelloWorldPort");

	public static void main(String[] args) {
		Service service = Service.create(SERVICE_NAME);
        // Endpoint Address
        String endpointAddress = "http://localhost:9001/HelloWorld";
        // If web service deployed on Tomcat (either standalone or embedded)
        // as described in sample README, endpoint should be changed to:
        // String endpointAddress = "http://localhost:8080/java_first_jaxws/services/hello_world";

        // Add a port to the Service
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        HelloWorld hw = service.getPort(HelloWorld.class);
        log.info(hw.sayHi("World"));

        User user = new UserImpl("World");
        log.info(hw.sayHiToUser(user));

        //say hi to some more users to fill up the map a bit
        user = new UserImpl("Galaxy");
        log.info(hw.sayHiToUser(user));

        user = new UserImpl("Universe");
        log.info(hw.sayHiToUser(user));

        log.info("Users: ");
        
        Map<Integer, User> users = hw.getUsers();
        for (Map.Entry<Integer, User> e : users.entrySet()) {
            log.info("  " + e.getKey() + ": " + e.getValue().getName());
        }

	}

}
