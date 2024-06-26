// RaceService.java

package com.example.futoverseny.service;

import com.example.futoverseny.Model.Race;
import com.example.futoverseny.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public Race addRace(Race race) {
        return raceRepository.save(race);
    }
}
