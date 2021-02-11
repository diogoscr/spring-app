package com.diogoscr.springboot.services;

import java.util.List;
import java.util.Optional;
import com.diogoscr.springboot.entities.Warning;
import com.diogoscr.springboot.repositories.WarningRepository;
import com.diogoscr.springboot.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Warning insert(Warning obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public Warning update(Long id, Warning obj) {
        Warning entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);

    }

    private void updateData(Warning entity, Warning obj) {
        entity.setTitle(obj.getTitle());
        entity.setDescription(obj.getDescription());
        entity.setPubDate(obj.getPubDate());
        entity.setVisDate(obj.getPubDate());
    }



}
