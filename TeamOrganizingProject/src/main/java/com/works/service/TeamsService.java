package com.works.service;

import com.works.configs.Standard;
import com.works.entities.Teams;
import com.works.repositories.TeamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class TeamsService {

    final TeamsRepository teamsRepository;

    public ResponseEntity teamInsert(Teams teams){
        try{
            teamsRepository.save(teams);
            Standard standard = new Standard(true,teams);
            return new ResponseEntity(standard, HttpStatus.OK);
        }
        catch (Exception exception){
            Standard standard = new Standard(false,exception.getMessage());
            return new ResponseEntity(standard,HttpStatus.BAD_REQUEST);
        }

    }


    public ResponseEntity<?> list(){
        Map<String, List<Map<String, Object>>> teamMap = new HashMap<>();

        List<List> queryResult = teamsRepository.getTeamsBy();

        for (List<Object> result : queryResult) {
            String playerName = (String) result.get(0);
            int age = (Integer) result.get(1);
            String teamName = (String) result.get(2);

            Map<String, Object> playerMap = new HashMap<>();
            playerMap.put("Name", playerName);
            playerMap.put("age", age);

            if (!teamMap.containsKey(teamName)) {
                teamMap.put(teamName, new ArrayList<>());
            }

            List<Map<String, Object>> playerList = teamMap.get(teamName);
            if (playerList.size() < 6) {
                playerList.add(playerMap);
            }
        }

        return new ResponseEntity<>(teamMap, HttpStatus.OK);

    }

    public ResponseEntity<?> backUpCreate() {
        Map<String, List<Map<String, Object>>> teamMap = new HashMap<>();

        List<List> queryResult = teamsRepository.getTeamsreplacement();

        for (List<Object> result : queryResult) {
            String playerName = (String) result.get(0);
            int age = (Integer) result.get(1);
            String teamName = (String) result.get(2);

            Map<String, Object> playerMap = new HashMap<>();
            playerMap.put("Name", playerName);
            playerMap.put("age", age);

            if (!teamMap.containsKey(teamName)) {
                teamMap.put(teamName, new ArrayList<>());
            }

            List<Map<String, Object>> playerList = teamMap.get(teamName);
            if (playerList.size() <3) {
                playerList.add(playerMap);
            }

        }

        return new ResponseEntity<>(teamMap, HttpStatus.OK);
    }



}
