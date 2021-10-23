package com.example.cep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cep2Application {

  private static final Logger log = LoggerFactory.getLogger(Cep2Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Cep2Application.class);
  }

  @Bean
  public CommandLineRunner demo(Cep2Repository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Cep2(17340000 , "Bauer"));
      repository.save(new Cep2(17340170 , "O'Brian"));
     

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Cep2 cep : repository.findAll()) {
        log.info(cep.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      Cep2 cep = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(cep.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByLocalidade("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }

}
