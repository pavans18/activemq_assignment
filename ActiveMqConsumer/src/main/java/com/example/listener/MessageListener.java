package com.example.listener;

import java.io.StringReader;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.activemq.util.ByteArrayInputStream;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.QosSettings;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;

@Component
public class MessageListener implements  jakarta.jms.MessageListener {
	
	@Override
	public void onMessage(Message message) {

		try {
			if (message instanceof TextMessage) {
				
				TextMessage textMessage = (TextMessage) message;
				
				String text = textMessage.getText();
				
				System.out.println("Received message: " + text);
			
			} else {
				System.out.println("Received message of unsupported type: " + message);
			}
		} catch (JMSException e) {
			System.err.println("Error while processing the message: " + e.getMessage());
		}
	}

	
//	@Override
//	public void onMessage(Message message) {
//
//		try {
//			if (message instanceof TextMessage) {
//				
//				TextMessage textMessage = (TextMessage) message;
//				
//				String xmlText = textMessage.getText();
//				
//				DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
//				DocumentBuilder builder = factory.newDocumentBuilder();
//				org.w3c.dom.Document document = builder.parse(new ByteArrayInputStream(xmlText.getBytes()));
//				
//				String rootElement = document.getDocumentElement().getNodeName();
//				
//				System.out.println("Received XML message: " + rootElement);
//			
//			} else {
//				System.out.println("Received message of unsupported type: " + message);
//			}
//		} catch (JMSException e) {
//			System.err.println("Error while processing the message: " + e.getMessage());
//		}
//	
//}
}



