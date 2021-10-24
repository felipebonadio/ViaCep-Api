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
      repository.save(new Cep("Barra Bonita" , "17340170", "Emilio Bressan", "Vila Operaria", "SP"));
      repository.save(new Cep("Chapecó" , "89802217", "Carlos Chagas", "Centro", "SC"));
      repository.save(new Cep("Avare" , "18701220", "Mato Grosso", "Braz II", "SP" ));
    };
  }
}
