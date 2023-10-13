package com.voterManagement.work.voterCardManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="StateName")
    private String stateNames;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStateNames() {
        return stateNames;
    }

    public void setStateNames(String stateNames) {
        this.stateNames = stateNames;
    }



    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", statesName='" + stateNames + '\'' +
                '}';
    }
}

