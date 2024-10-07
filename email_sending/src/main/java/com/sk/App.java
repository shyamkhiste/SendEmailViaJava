package com.sk;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("preparing to send massage");
    	
    	
    	String from = "shyamkhiste4459@gmail.com";
    	System.out.println("Type recipient email...");
    	String to = "";
    	Scanner ref1 = new Scanner(System.in);
    	  to = ref1 .next();
    	  System.out.println("Subject : ");
    	  String subject = "";
    	  Scanner ref2 = new Scanner(System.in);
    	  subject = ref2 .next();
    	  System.out.println("Write message here...");
    	  String message = "";
    	  Scanner ref3 = new Scanner(System.in);
    	  message = ref3 .next();
    	  
    	
      
      
       
       
       sendEmail(message,subject, to ,from);
  	    
    }
    
	//This is responsible to send email...
	private static void sendEmail(String message, String subject, String to, String from) {
		
		//variable for gmail..
		String host= "smtp.gmail.com";
		
		//get system property
		
		Properties properties = System.getProperties();
		System.out.println("Properties"+ properties);
		
		//setting important information to properties object
		// set host
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//step1 : to get the session object
		
		Session session = Session.getInstance (properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("shyamkhiste4459@gmail.com"," hunjquoksppcbwig");
			}
			
			
		});
		session.setDebug(true);
		// step2: compose the message [text, multimedia]
		MimeMessage m = new MimeMessage(session);
		try {
		// from email
		m.setFrom(from);
		// adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
		//adding text to message 
		m.setText(message);
		//send
		//step3: send the message using transport class
		
		Transport.send(m);
		
		System.out.println("Email send successfully....");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		}
	}

