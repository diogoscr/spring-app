package com.diogoscr.springboot.services;

import java.util.List;
import java.util.Optional;
import com.diogoscr.springboot.entities.Warning;
import com.diogoscr.springboot.repositories.WarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarningService {
    
    @Autowired
    private WarningRepository repository;

    public List<Warning> findAll() {
        return repository.findAll();
    }

    public Warning findById(Long id) {
        Optional<Warning> obj = repository.findById(id);
        return obj.get();
    }

    public Warning insert(Warning obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
