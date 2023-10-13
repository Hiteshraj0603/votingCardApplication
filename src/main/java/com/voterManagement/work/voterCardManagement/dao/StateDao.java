package com.voterManagement.work.voterCardManagement.dao;

import com.voterManagement.work.voterCardManagement.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateDao extends JpaRepository<State,Integer> {
    List<State> findByStateNames(String name);
}
