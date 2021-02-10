package com.diogoscr.springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.diogoscr.springboot.entities.Warning;
import com.diogoscr.springboot.services.WarningService;

@RestController
@RequestMapping(value = "/warnings")
public class WarningResource {

    @Autowired
    private WarningService service;

    @GetMapping
    public ResponseEntity<List<Warning>> findAll() {
        List<Warning> list = service.findAll();
        return ResponseEntity.ok().body(list);
        
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Warning> findById(@PathVariable Long id) {
        Warning obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
