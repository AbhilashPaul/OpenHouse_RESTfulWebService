package com.example.openhouse.models;

import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="action_id")
    private long id;

    @Column(nullable=false, name="time")
    private Date time;

    @Column(name="type")
    private String type;

    /*@ManyToOne
    @JoinColumn(name="log_id")
    private Log log;*/

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Date getTime() { return time; }

    public void setTime(Date time) { this.time = time; }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

//    public Log getLog() { return log; }
//
//    public void setLog(Log log) { this.log = log; }

    public Action(Date time, String type, Log log) {
        this.time = time;
        this.type = type;
       // this.log = log;
    }

    public Action() {
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", time=" + time +
                ", type='" + type + '\'' +
                //", log_id=" + log +
                '}';
    }
}
