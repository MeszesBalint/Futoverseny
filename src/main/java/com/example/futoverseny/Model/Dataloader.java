package com.example.futoverseny.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.futoverseny.repository.RunnerRepository;
import com.example.futoverseny.repository.RaceRepository;
import com.example.futoverseny.repository.ResultRepository;

import java.util.List;

@Component
public class Dataloader implements CommandLineRunner {

    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    @Autowired
    public Dataloader(RunnerRepository runnerRepository, RaceRepository raceRepository, ResultRepository resultRepository) {
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Betöltjük a tesztadatokat a futókhoz
        Runner runner1 = new Runner("John Doe", 30, "male");
        Runner runner2 = new Runner("Jane Smith", 25, "female");
        Runner runner3 = new Runner("Bob Johnson", 40, "male");
        Runner runner4 = new Runner("Alice Brown", 35, "female");
        runnerRepository.saveAll(List.of(runner1, runner2, runner3, runner4));

        // Betöltjük a tesztadatokat a versenyekhez
        Race race1 = new Race("Marathon", 42195); // Távolság méterben
        Race race2 = new Race("Félmaraton", 21097);
        raceRepository.saveAll(List.of(race1, race2));

        // Betöltjük a tesztadatokat az eredményekhez
        Result result1 = new Result(runner1, race1, 180); // John Doe, Marathon, 180 perces időeredmény
        Result result2 = new Result(runner2, race1, 200); // Jane Smith, Marathon, 200 perces időeredmény
        Result result3 = new Result(runner3, race2, 90);  // Bob Johnson, Half Marathon, 90 perces időeredmény
        Result result4 = new Result(runner4, race2, 100); // Alice Brown, Half Marathon, 100 perces időeredmény
        resultRepository.saveAll(List.of(result1, result2, result3, result4));
    }
}
