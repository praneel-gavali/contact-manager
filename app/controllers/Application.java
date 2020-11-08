package controllers;

import models.Contact;
import models.User;
import org.hibernate.exception.ConstraintViolationException;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

import javax.persistence.Query;
import java.util.List;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void list() {
        User user = User.find("byUsername", session.get("username")).first();
        final Query nativeQuery = Contact.em().createNativeQuery("select * from Contact c where c.user_id='" + user.id + "'", Contact.class);
        final List<Contact> contacts = nativeQuery.getResultList();
        render(contacts);
    }

    public static void form(Long id) {
        if (id == null) {
            render();
        }
        Contact contact = Contact.findById(id);
        render(contact);
    }

    public static void save(@Valid Contact contact) {
        if (validation.hasErrors()) {
            if (request.isAjax()) {
                error("Invalid value");
            }
            render("@form", contact);
        }
        User user = User.find("byUsername", session.get("username")).first();
        contact.user = user;
        try {
            contact.save();
        } catch (ConstraintViolationException ex) {
            error(ex);
        }
        list();
    }


}