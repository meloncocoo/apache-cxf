package org.melon.ws.server;

import javax.xml.ws.Endpoint;

import org.apache.log4j.Logger;

public class Server {
	
	private static final Logger log = Logger.getLogger(Server.class);
	
	protected Server() throws Exception {
        // START SNIPPET: publish
		log.info("Starting Server");
		HelloWorldImpl implementor = new HelloWorldImpl();
        String address = "http://localhost:9001/HelloWorld";
        Endpoint.publish(address, implementor);
        // END SNIPPET: publish
    }

	public static void main(String[] args) throws Exception {
		new Server();
		log.info("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        log.info("Server exiting");
        System.exit(0);
	}

}
