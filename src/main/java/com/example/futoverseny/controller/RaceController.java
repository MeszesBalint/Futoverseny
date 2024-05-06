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

    @PostMapping("addRace")
    public ResponseEntity<?> addRace(@Valid @RequestBody Race race, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Invalid data provided", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(raceService.addRace(race), HttpStatus.CREATED);
    }
}
