// RaceController.java

package com.example.futoverseny.controller;

import com.example.futoverseny.Model.Race;
import com.example.futoverseny.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {

    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("getAllRaces")
    public List<Race> getAllRaces() {
        return raceService.getAllRaces();
    }

    @PostMapping("/addRace")
    public ResponseEntity<?> addRaceFromForm(@RequestParam("name") String name, @RequestParam("distance") int distance) {
        Race newRace = new Race(name, distance);
        Race addedRace = raceService.addRace(newRace);
        if (addedRace != null) {
            return ResponseEntity.ok().body("{\"success\": true}");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"success\": false}");
        }
    }

}
