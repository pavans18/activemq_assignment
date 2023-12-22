package com.example.publisher;



import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Message;

import jakarta.jms.Connection;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Queue;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

@Component
public class MessagePublisher {

	
	@Autowired
	ActiveMQConnectionFactory connectionFactory;

	public void PublishMessage(String queueName, Message message) {

		try {
			Connection connection = connectionFactory.createConnection();

			connection.start();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Queue queue = session.createQueue(queueName);

			TextMessage textMessage = session.createTextMessage();

			MessageProducer producer = session.createProducer(queue);

			producer.send(textMessage);

			session.close();

			connection.close();

		} catch (JMSException e) {

			e.printStackTrace();
		}

	}
}
