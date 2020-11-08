package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User extends Model {

    @Required
    public String username;

    @Required
    public String password;

    @Required
    public String email;

    @OneToMany(mappedBy = "user")
    public Set<Contact> contacts;

}

