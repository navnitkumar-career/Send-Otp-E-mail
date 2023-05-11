package com.otp.Servies;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class Servies {
	private static void sendEmail(String message, String subject, String to, String from) {

		// variable for gmail
		String host = "smtp.gmail.com";

		// get the system property
		Properties properties = System.getProperties();
		System.out.println(properties);

		// important information to setting
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		
		// step1=get the session object
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("srimcasymca@gmail.com", "srimca123456");
			}
			
			
		});


		// step2= compose the message

		MimeMessage m = new MimeMessage(session);

		try {

			// from

			m.setFrom(from);

			// to

			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// subject

			m.setSubject(subject);

			// message

			m.setText(message);

			// step3=send the message using transport class

			Transport.send(m);

			System.out.println("sent sucess........");

		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
