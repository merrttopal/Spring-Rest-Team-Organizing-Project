package com.works.entities.projection;

import com.works.entities.Footbollers;
import com.works.entities.Teams;

/**
 * A Projection for the {@link Teams} entity
 */
public interface TeamsInfo {
    Long getId();

    String getTeams();

    FootbollersInfo getFootboller();

    /**
     * A Projection for the {@link Footbollers} entity
     */
    interface FootbollersInfo {
        Integer getFid();

        String getName();

        String getSurname();

        Integer getAge();
    }
}