package com.example.demo;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // Get a random fact
    @GetMapping("/fact")
    public Fact getRandomFact() {
        List<Fact> all = repo.findAll();
        return all.get(random.nextInt(all.size()));
    }

    // Get all facts
    @GetMapping("/facts")
    public List<Fact> getAllFacts() {
        return repo.findAll();
    }

    // Get a fact using ID
    @GetMapping("/fact/{id}")
    public Fact getFactById(@PathVariable Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Fact not found"));
    }

    // Add a new fact
    @PostMapping("/fact")
    public Fact addFact(@RequestBody String newFact) {
        Fact fact = new Fact(newFact);
        return repo.save(fact);
    }

    // Edit an existing fact
    @PutMapping("/fact/{id}")
    public Fact editFact(@PathVariable Long id, @RequestBody Fact updatedFact) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setText(updatedFact.getText());
                    return repo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Fact not found"));
    }

    // Delete a fact
    @DeleteMapping("/fact/{id}")
    public void deleteFact(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Fact not found");
        }
        repo.deleteById(id);
    }
}
