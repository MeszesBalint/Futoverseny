// RunnerService.java

package com.example.futoverseny.service;

import com.example.futoverseny.Model.Runner;
import com.example.futoverseny.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public List<Runner> getAllRunners() {
        return runnerRepository.findAll();
    }

    public Runner addRunner(Runner runner) {
        return runnerRepository.save(runner);
    }
}
