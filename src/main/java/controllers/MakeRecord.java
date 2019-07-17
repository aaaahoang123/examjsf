package controllers;

import entities.LeaveRecord;
import entities.User;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class MakeRecord {
    private LeaveRecord record;

    public void doSubmit() {
        HttpSession sess = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.record.setId(System.currentTimeMillis());
        this.record.setAccept(false);
        this.record.setRequestBy(((User)sess.getAttribute("user")).getId());
        LeaveRecord.save(this.record);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "/list-records.xhtml";// define the navigation rule that must be used in order to redirect the user to the adequate page...
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }

    public LeaveRecord getRecord() {
        return record;
    }

    public void setRecord(LeaveRecord record) {
        this.record = record;
    }
}
