package com.netcracker;

import com.sun.mail.smtp.SMTPMessage;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.mail.*;
import java.util.Properties;



@WebServlet("/send")
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email=req.getParameter("email");
        String text=req.getParameter("textarea");
        String sub=req.getParameter("subject");

        Properties mailProps = new Properties();

        mailProps.put("mail.smtp.starttls.enable", "true");
        mailProps.put("mail.transport.protocol","smtp");
        mailProps.put("mail.smtp.host","smtp.yandex.ru");
        mailProps.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(mailProps,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return(new PasswordAuthentication("testMailJavaMail","1324354657"));
            }
        });
        try {
            SMTPMessage message = new SMTPMessage(session);
            message.setEnvelopeFrom("testMailJavaMail@yandex.ru");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

            message.setSubject(sub, "koi8-r");
            message.setText(text, "koi8-r");

            Transport.send(message);
        } catch (MessagingException m){ m.printStackTrace();}

    }
}
