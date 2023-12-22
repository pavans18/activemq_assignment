package com.example.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@Configuration
public class ActiveMqConfig {
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		
		activeMQConnectionFactory.setUserName("admin");
		activeMQConnectionFactory.setPassword("admin");
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		
		return activeMQConnectionFactory;
	}
	
	@Bean
	public DefaultMessageListenerContainer container() {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(activeMQConnectionFactory());
		container.setDestinationName("MyQueue");    
		container.setMessageListener(new com.example.listener.MessageListener());
		return container;
	}

}
