package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FactRepository extends JpaRepository<Fact, Long> {
}

