package com.diogoscr.springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Warning> insert(@RequestBody Warning obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    } 

}
