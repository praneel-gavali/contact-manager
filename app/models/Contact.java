package models;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "Contact", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "email"}))
public class Contact extends Model {

    @Required
    public String firstname;

    @Required
    public String name;

    @Required
    public Date birthdate;

    @Required
    @Email
    public String email;

    @ManyToOne
    public User user;

}

