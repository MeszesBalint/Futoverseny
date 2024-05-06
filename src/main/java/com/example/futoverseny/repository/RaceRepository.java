// RaceRepository.java

package com.example.futoverseny.repository;

import com.example.futoverseny.Model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
}
