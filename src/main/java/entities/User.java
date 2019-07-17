package entities;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class User {
    @Id
    private long id;
    @Index
    private String username;
    @Index
    private String password;
    @Index
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static User save(User user) {
        ObjectifyService.register(User.class);
        Objectify ofy = ObjectifyService.ofy();
        Key<User> key = ofy.save().entity(user).now();
        return ofy.load().key(key).now();
    }

    public static User getByUsernameAndPassword(String username, String password) {
        ObjectifyService.register(User.class);
        Objectify ofy = ObjectifyService.ofy();
        return ofy.load().type(User.class).filter("username=", username)
                .filter("password=", password)
                .first().now();
    }
}
