package com.example.demo;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class FactsController {

    private final FactRepository repo;
    private final Random random = new Random();

    public FactsController(FactRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/fact")
    public Fact getRandomFact() {
        List<Fact> all = repo.findAll();
        return all.get(random.nextInt(all.size()));
    }

    @PostMapping("/fact")
    public Fact addFact(@RequestBody String newFact) {
        Fact fact = new Fact(newFact);
        return repo.save(fact);
    }

    @GetMapping("/facts")
    public List<Fact> getAllFacts() {
        return repo.findAll();
    }
}
