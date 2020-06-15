package com.example.demojooq;

import com.example.demojooq.model.tables.Person;
import com.example.demojooq.model.tables.records.PersonRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Result;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class PersonDao {

    private final DefaultDSLContext dsl;

    public PersonDao(DefaultDSLContext dsl) {
        this.dsl = dsl;
        log.info("dsl: {}", this.dsl.dialect());
    }

    void insert(PersonRecord personRecord) {
        this.dsl.insertInto(personRecord.getTable())
                .set(personRecord)
                .execute();
    }

    PersonRecord personRecordById(Integer id) {
        Result<PersonRecord> fetch = this.dsl.selectFrom(Person.PERSON.asTable())
                .where(Person.PERSON.PID.eq(id))
                .fetch();
        return fetch.get(0);
    }

    void updatePerson(PersonRecord personRecord) {
        this.dsl.insertInto(personRecord.getTable())
                .set(personRecord)
                .onDuplicateKeyUpdate()
                .set(personRecord)
                .execute();
    }
}
