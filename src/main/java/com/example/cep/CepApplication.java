package com.example.cep;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CepApplication {

   public static void main(String[] args) {
    SpringApplication.run(CepApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CepRepository repository) {
    return (args) -> {     
      repository.save(new Cep("Barra Bonita" , "17340000"));
      repository.save(new Cep("Igaraçu" , "17340170"));
      repository.save(new Cep("Avaré" , "17340190"));
    };
  }

}
