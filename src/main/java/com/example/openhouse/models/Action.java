package com.example.openhouse.models;

import javax.persistence.*;
import java.util.Date;

/*
  Action Entity Class
  Author: Abhilash Paul
  Date: 22 Nov 2019
*/

@Entity
@Table(name="Actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(nullable=false, name="time")
    private Date time;

    @Column(name="type", nullable=false)
    private String type;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "property_id")
    private Property properties;

    @ManyToOne
    private Log log;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Date getTime() { return time; }

    public void setTime(Date time) { this.time = time; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public Property getProperties() { return properties; }

    public void setProperty(Property property) { this.properties = property; }

    public Action(Date time, String type, Property property) {
        this.time = time;
        this.type = type;
        this.properties = property;
    }

    public Action() {
    }
}
