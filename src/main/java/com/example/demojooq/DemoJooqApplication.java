package com.example.demojooq;

import com.example.demojooq.model.tables.records.PersonRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class DemoJooqApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJooqApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(PersonDao personDao) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                /*Arrays.asList("Amar","Ashish")
                        .forEach(name -> {
                            PersonRecord personRecord = new PersonRecord();
                            personRecord.setName(name);
                            personDao.insert(personRecord);
                            *//*log.info("Person Id: {}", insert.getPid());
                            log.info("Person Name: {}", insert.getName());*//*
                        });*/
                //personDao.personRecordById()

                PersonRecord personRecord = personDao.personRecordById(1);
                log.info("Person Id: {}", personRecord.getPid());
                log.info("Person Name: {}", personRecord.getName());
                PersonRecord personRecord1 = new PersonRecord();
                personRecord1.setPid(5);
                personRecord1.setName("Amaresh");
                personDao.updatePerson(personRecord1);
            }
        };
    }
}
