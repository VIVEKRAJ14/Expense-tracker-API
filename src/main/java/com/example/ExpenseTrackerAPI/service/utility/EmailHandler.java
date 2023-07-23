package com.example.ExpenseTrackerAPI.service.utility;

import org.apache.logging.log4j.message.Message;
import org.hibernate.Session;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class EmailHandler {

    private static final String EMAIL_USERNAME ="mailtesting673@gmail.com";
    private static final String EMAIL_PASSWORD ="asdfghjkl";


    public static void sendEmail(String toEmail, String subject, String body) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD.toCharArray());
            }
        });

        try {
            Message message = new Message(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            System.out.println("OTP sent successfully to " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
