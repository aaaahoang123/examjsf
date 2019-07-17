package controllers;

import entities.LeaveRecord;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class ListRecords {
    private List<LeaveRecord> datas = LeaveRecord.getList();

    public List<LeaveRecord> getDatas() {
        return datas;
    }

    public void setDatas(List<LeaveRecord> datas) {
        this.datas = datas;
    }
}
