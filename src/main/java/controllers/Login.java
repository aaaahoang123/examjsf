package controllers;

import entities.User;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@ManagedBean
public class Login {
    private static final Logger LOGGER = Logger.getLogger(Login.class.getName());

    private User user = new User();

    public void doSubmit() {
        User u = User.getByUsernameAndPassword(this.user.getUsername(), this.user.getPassword());
        if (u == null) {
            this.user.setId(System.currentTimeMillis());
            this.user.setRole("emp");
            u = User.save(this.user);
        }
        HttpSession sess = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        sess.setAttribute("user", u);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "/make-record.xhtml";// define the navigation rule that must be used in order to redirect the user to the adequate page...
                NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
