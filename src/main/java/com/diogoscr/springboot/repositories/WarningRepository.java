package com.diogoscr.springboot.repositories;

import com.diogoscr.springboot.entities.Warning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarningRepository extends JpaRepository<Warning, Long>{}