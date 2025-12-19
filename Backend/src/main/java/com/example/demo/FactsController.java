package com.example.demo;

import java.util.ArrayList;
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
    // List of facts
    private final List<String> facts = new ArrayList<>(List.of(
        "It is said that the term 'bug' in computing came about in 1947 when a moth was found to be the cause of a malfunction in the Harvard Mark II computer, however in reality the term bug was already used by Thomas Edison and other engineers in the 1870s to describe electrical faults as if they were pesky bugs.",
        "Quantum entanglement is when two particles can be linked in such a way that observing the properties of one instantaneously affects the other, regardless of the distance separating them, even if they were across the universe. Einstein called this 'spooky action at a distance'.",
        "From what we know of time dilation and relativity, time does not pass at the same speed for everyone. According to Einstein's theory of relativity, time moves slower for objects in strong gravitational fields or moving at high speeds. As a result GPS satellites need constant correction to function accurately.",
        "Neptune the planet was discovered mathematically before being seen. It is believed to be an Ice Giant with winds faster than 1,200 miles an hour and takes nearly 165 Earth years to orbit the Sun, it is so far away from the sun that light on the planet appears more like faint twilight. Methane in its atmosphere absorbs red light, giving it a distinct blue hue."
    ));

    // Return a random fact
    @GetMapping("/fact")
    public String getFact() {
        return facts.get(new Random().nextInt(facts.size()));
    }

    // Add a new fact to the list
    @PostMapping("/fact")
    public String addFact(@RequestBody String newFact) {
        facts.add(newFact);
        return "Fact added!";
    }

    // Return the full list of facts
    @GetMapping("/facts")
    public List<String> getAllFacts() {
        return facts;
    }
}
