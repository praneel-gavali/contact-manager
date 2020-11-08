package controllers;

import models.User;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        final User user = User.find("byUsername", username).first();
        if (user != null && user.password.equals(password)) {
            return true;
        }
        return false;
    }
}
