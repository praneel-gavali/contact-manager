package jobs;

import models.Contact;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Mail;

import java.util.List;

public class EmailSender {
    private static Logger log = LoggerFactory.getLogger(EmailSender.class);

    public static void sendEmail(List<Contact> contacts) {
        for (Contact contact : contacts) {
            send(contact);
        }
    }

    private static void send(Contact contact) {
        try {
            SimpleEmail email = new SimpleEmail();
            email.setFrom(contact.user.email);
            email.setSubject("Happy Birthday");
            email.setMsg("Happy Birthday! Have a great year ahead! :)");
            email.addTo(contact.email, contact.firstname);
            Mail.send(email);
        } catch (EmailException e) {
            log.error("Failed to send an email");
        }
    }
}
