package com.example.openhouse.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(nullable=false,name="user_id")
    private String userId;

    @Column(nullable=false, name="session_id")
    private String sessionId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name="log_id")
    private List<Action> actions = new ArrayList<>();

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public Log(String userId, String sessionId) {
        this.userId = userId;
        this.sessionId = sessionId;
    }

    public Log() {
    }
}
