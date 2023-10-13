package com.voterManagement.work.voterCardManagement.service;

import com.voterManagement.work.voterCardManagement.entity.Voter;

import java.util.List;

public interface VoterService {

    List<Voter> findAll();
    String save(Voter voter);
    List<Voter> getAll();
    Voter addVoter(Voter voter);
    List<Voter> getVoterByState(String name);
    List<Voter> getVoterByStateName(String name);
}
