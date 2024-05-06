// RunnerRepository.java

package com.example.futoverseny.repository;

import com.example.futoverseny.Model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Long> {
}
