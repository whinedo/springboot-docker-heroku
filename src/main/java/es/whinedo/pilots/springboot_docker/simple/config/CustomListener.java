package es.whinedo.pilots.springboot_docker.simple.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class CustomListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomListener.class);

    @Autowired
    private Environment environment;

    @EventListener
    public void handleEvent(RequestHandledEvent e) {
        try {
            LOGGER.info(InetAddress.getLocalHost().getHostAddress()+":"+environment.getProperty("local.server.port"));
        } catch (UnknownHostException e1) {
            LOGGER.error("Cannot get ip address");
        }
    }
}
