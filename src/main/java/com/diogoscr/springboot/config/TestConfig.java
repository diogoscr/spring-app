package com.diogoscr.springboot.config;

import java.util.Arrays;
import com.diogoscr.springboot.entities.Warning;
import com.diogoscr.springboot.repositories.WarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private WarningRepository warningRepository;

    @Override
    public void run(String...args) throws Exception {
		
        Warning w1 = new Warning(null, "Aviso de matricula", "Atencao alunos com o periodo de matricula", "20/01/2021", "25/01/2021");
        Warning w2 = new Warning(null, "AVISO URGENTE", "Medidas de seguranca contra o COVID19", "01/02/2021", "02/02/2021");

        warningRepository.saveAll(Arrays.asList(w1,w2));

    }
    
}
