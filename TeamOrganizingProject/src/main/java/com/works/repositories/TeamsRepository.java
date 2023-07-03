package com.works.repositories;

import com.works.entities.Teams;
import com.works.entities.projection.TeamsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TeamsRepository extends JpaRepository<Teams, Integer> {

    @Query(value = "SELECT f.NAME, f.AGE, t.TEAMS\n" +
            "FROM FOOTBOLLERS AS f\n" +
            "INNER JOIN TEAMS t ON f.FID = t.FID\n" +
            "WHERE t.TEAMS IN ('a', 'b')\n" +
            "ORDER BY f.AGE ASC", nativeQuery = true)
    List<List> getTeamsBy();


    @Query(value = "SELECT f.NAME, f.AGE, t.TEAMS\n" +
            "FROM FOOTBOLLERS AS f\n" +
            "INNER JOIN TEAMS t ON f.FID = t.FID\n" +
            "WHERE t.TEAMS IN ('a', 'b')\n" +
            "ORDER BY f.AGE ASC\n" +
            "LIMIT 12, 100", nativeQuery = true)
    List<List> getTeamsreplacement ();
}


;