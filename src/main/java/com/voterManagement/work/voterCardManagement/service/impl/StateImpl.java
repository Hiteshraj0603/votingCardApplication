package com.voterManagement.work.voterCardManagement.service.impl;

import com.voterManagement.work.voterCardManagement.dao.StateDao;
import com.voterManagement.work.voterCardManagement.entity.State;
import com.voterManagement.work.voterCardManagement.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateImpl implements StateService {

    @Autowired
    private StateDao stateDao;

    @Override
    public List<State> getAllState()
    {
        return stateDao.findAll();
    }

    public List<State> getStates(String stateName)
    {

        return stateDao.findByStateNames(stateName);
    }
}
