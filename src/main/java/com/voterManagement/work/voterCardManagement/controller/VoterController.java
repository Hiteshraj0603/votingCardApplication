package com.voterManagement.work.voterCardManagement.controller;

import com.voterManagement.work.voterCardManagement.dao.StateDao;
import com.voterManagement.work.voterCardManagement.dao.VoterDao;
import com.voterManagement.work.voterCardManagement.entity.State;
import com.voterManagement.work.voterCardManagement.entity.Voter;
import com.voterManagement.work.voterCardManagement.service.StateService;
import com.voterManagement.work.voterCardManagement.service.VoterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/voters")
public class VoterController {

    @Autowired
    private StateService stateService;

    @Autowired
    private VoterService voterService;

    @Autowired
    private StateDao stateDao;

    @Autowired
    private VoterDao voterDao;

    @GetMapping("/list")
    public String listOfVoters(Model model){
        List<Voter> allVoters = voterService.findAll();
        model.addAttribute("voterService",allVoters);
        model.addAttribute("stateService",stateService.getAllState());
        return "voters/voter-list";
    }

    @GetMapping("/list/{stateName}")
    public String getVotersByState(@PathVariable("stateName")String stateName, Model model){
        List<Voter> allVoters = voterService.getVoterByState(stateName);
        model.addAttribute("voterService",allVoters);
        model.addAttribute("stateName",stateName);
        model.addAttribute("stateService", stateService.getAllState());
        return "voters/voter-list";
    }

    @GetMapping("/voterForm")
    public String voterForm(Model model){
        Voter voter = new Voter();
        model.addAttribute("voter",voter);
        model.addAttribute("stateService",stateService.getAllState());
        return "voters/voter-form";
    }

    @PostMapping("/addVoter")
    public String addVoter(@Valid @ModelAttribute("voter")Voter allVoter, BindingResult result,Model model){
        if ((result.hasErrors())&& allVoter.getAge()<18){
            model.addAttribute("stateService", stateService.getAllState());
            return "voters/voter-form";
        }

        State state = stateDao.findById(allVoter.getState_id()).get();
        allVoter.setStateNames(state.getStateNames());

        System.out.println(allVoter);
        String list = voterService.save(allVoter);
        if (list.equals("Eligible")){
            return "redirect:/voters/voter-list";
        }else{
            model.addAttribute("stateService", stateService.getAllState());
            return "voters/VoterAgeInvalid";
        }
    }

    @ResponseBody
    @GetMapping("/listApi")
    public List<Voter> getVotersApi(){
        return voterService.getAll();
    }

    @ResponseBody
    @PostMapping("/addVoterApi")
    public Voter addVoterApi(@RequestBody Voter voter){
        return voterService.addVoter(voter);
    }

    @ResponseBody
    @GetMapping("/listStateApi")
    public List<State> getStateListApi(){
        return stateService.getAllState();
    }

    @ResponseBody
    @GetMapping("/voterListByStateApi/{name}")
    public List<Voter> getVoterListByStateApi(@PathVariable("name") String name){
        return voterService.getVoterByStateName(name);
    }
}
