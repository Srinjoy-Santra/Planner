package com.example.newu.planner;

/**
 * Created by nEW u on 18-Jun-17.
 */

public class TaskType {
    private String taskname;
    private String subtask;
    private String note;
    private int _id;
    private String time;
    public TaskType() {
        this.taskname ="" ;
        this.subtask="";
        this.note="";
        this.time="";

    }

    public TaskType(String t,String subtask,String note,String time) {

        this.taskname = t;
        this.subtask=subtask;
        this.note=note;
        this.time=time;


    }

    public String getNote() {
        return note;
    }

    public int get_id() {

        return _id;
    }
    public String getTaskname() {
        return taskname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubtask() {

        return subtask;
    }

    public void setSubtask(String subtask) {
        this.subtask = subtask;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public void set_id(int _id) {

        this._id = _id;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
}
