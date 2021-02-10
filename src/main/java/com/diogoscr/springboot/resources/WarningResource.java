package com.diogoscr.springboot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diogoscr.springboot.entities.Warning;

@RestController
@RequestMapping(value = "/warnings")
public class WarningResource {

    @GetMapping
    public ResponseEntity<Warning> findAll() {
        Warning w = new Warning(1L, "aviso de matrícula", "prezados alunos realizarem a matrícula");
        return ResponseEntity.ok().body(w);
        
    }


    
}
