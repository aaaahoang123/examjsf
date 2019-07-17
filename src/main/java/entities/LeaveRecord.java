package entities;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.List;

@Entity
public class LeaveRecord {
    @Id
    private long id;
    @Index
    private long requestBy;
    @Index
    private String reason;
    @Index
    private boolean accept;

    private static Objectify ofy() {
        ObjectifyService.register(LeaveRecord.class);
        return ObjectifyService.ofy();
    }
    public static List<LeaveRecord> getList() {
        return ofy().load().type(LeaveRecord.class).list();
    }

    public static LeaveRecord save(LeaveRecord record) {
        Key<LeaveRecord> key = ofy().save().entity(record).now();
        return ofy().load().key(key).now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(long requestBy) {
        this.requestBy = requestBy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}
