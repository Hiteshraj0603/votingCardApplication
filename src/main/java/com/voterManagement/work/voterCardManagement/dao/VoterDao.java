package com.voterManagement.work.voterCardManagement.dao;
import com.voterManagement.work.voterCardManagement.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoterDao extends JpaRepository<Voter,Integer> {
    List<Voter> findByStateNames(String name);


}
