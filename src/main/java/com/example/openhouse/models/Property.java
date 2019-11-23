package com.example.openhouse.models;

import javax.persistence.*;

/*
  Property Entity Class
  Used for storing action properties
  Author: Abhilash Paul
  Date: 22 Nov 2019
*/

@Entity
@Table(name="Properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="location_x")
    private Integer locationX;

    @Column(name="location_y")
    private Integer locationY;

    @Column(name="viewed_id")
    private String viewedId;

    @Column(name="page_from")
    private String pageFrom;

    @Column(name="page_to")
    private String pageTo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getLocationX() {
        return locationX;
    }

    public void setLocationX(Integer locationX) {
        this.locationX = locationX;
    }

    public Integer getLocationY() {
        return locationY;
    }

    public void setLocationY(Integer locationY) {
        this.locationY = locationY;
    }

    public String getViewedId() {
        return viewedId;
    }

    public void setViewedId(String viewedId) {
        this.viewedId = viewedId;
    }

    public String getPageFrom() {
        return pageFrom;
    }

    public void setPageFrom(String pageFrom) {
        this.pageFrom = pageFrom;
    }

    public String getPageTo() {
        return pageTo;
    }

    public void setPageTo(String pageTo) {
        this.pageTo = pageTo;
    }

    public Property(Integer locationX, Integer locationY, String viewedId, String pageFrom, String pageTo) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.viewedId = viewedId;
        this.pageFrom = pageFrom;
        this.pageTo = pageTo;
    }

    public Property() {
    }
}
