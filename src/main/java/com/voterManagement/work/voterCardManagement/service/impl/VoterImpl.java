package com.voterManagement.work.voterCardManagement.service.impl;

import com.voterManagement.work.voterCardManagement.dao.StateDao;
import com.voterManagement.work.voterCardManagement.dao.VoterDao;
import com.voterManagement.work.voterCardManagement.entity.State;
import com.voterManagement.work.voterCardManagement.entity.Voter;
import com.voterManagement.work.voterCardManagement.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;

@Service
public class VoterImpl implements VoterService {

    @Autowired
    private VoterDao voterDao;

    @Autowired
    private StateDao stateDao;

    @Autowired
    public VoterImpl(VoterDao voterDao) {
        this.voterDao = voterDao;
    }

    @Override
    public List<Voter> findAll() {
        HashMap<Integer,String> findVoter = new HashMap<>();
        List<State> getAllState =stateDao.findAll();

        List<Voter> getAllVoter =voterDao.findAll();
        for (int i =0;i<getAllState.size();i++){
            State stateTemp = getAllState.get(i);
            findVoter.put(stateTemp.getId(), stateTemp.getStateNames());
        }
            for (int i=0;i<getAllVoter.size();i++){
                Voter voterTemp = getAllVoter.get(i);
                voterTemp.setStateNames(findVoter.get(voterTemp.getState_id()));
            }

        return getAllVoter;
    }

    @Override
    public String save(Voter voter) {

        LocalDate dob = voter.getDob();
        LocalDate currDate =LocalDate.now();
        Period period = Period.between(dob,currDate);
        voter.setAge(period.getYears());
        if(voter.getAge()<18){
        return "Not Eligible";
        }else {
            voterDao.save(voter);
            return "Eligible to Vote";
        }

    }

    @Override
    public List<Voter> getAll() {
        List<Voter> allVoters =voterDao.findAll();

        return allVoters;
    }

    @Override
    public Voter addVoter(Voter voter) {
        return voterDao.save(voter);
    }

    @Override
    public List<Voter> getVoterByState(String name) {
        return voterDao.findByStateNames(name);
    }

    @Override
    public List<Voter> getVoterByStateName(String name) {
        return voterDao.findByStateNames(name);
    }
}
