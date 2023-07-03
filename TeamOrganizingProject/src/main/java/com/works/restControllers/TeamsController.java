package com.works.restControllers;

import com.works.entities.Footbollers;
import com.works.entities.Teams;

import com.works.repositories.TeamsRepository;
import com.works.service.TeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamsController {
    final HttpServletRequest request;
    final HttpServletResponse response;
    final TeamsService service;
    private final TeamsRepository teamsRepository;

    @PostMapping("/teamInsert")
    public ResponseEntity teamInsert(@Valid @RequestBody Teams teams, Footbollers footbollers) {
        HttpSession session = request.getSession();
        footbollers.setFid((Integer) session.getAttribute("fid"));
        teams.setFootboller(footbollers);
        return service.teamInsert(teams);
    }

    @GetMapping("/list")
    public ResponseEntity teamlist(){
        return service.list();
    }

    @GetMapping("/backUpCreate")
    public ResponseEntity backUpCreate(){
        return service.backUpCreate();
    }


}
