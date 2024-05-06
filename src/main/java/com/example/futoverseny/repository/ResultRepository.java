// ResultRepository.java

package com.example.futoverseny.repository;


import com.example.futoverseny.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
}
