package jobs;

import models.Contact;
import play.jobs.Job;
import play.jobs.On;

import java.util.List;

@On("${cron.noon}")
public class BirthdayReminder extends Job {

    public void doJob() {
        final List<Contact> contacts = Contact.em().createNativeQuery(
                "SELECT * FROM CONTACT C WHERE C.birthdate = " +
                        "(SELECT CURDATE() + 1)", Contact.class).getResultList();

        EmailSender.sendEmail(contacts);
    }
}
