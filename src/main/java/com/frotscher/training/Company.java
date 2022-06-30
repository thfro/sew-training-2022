package com.frotscher.training;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Person> persons;

    public Company(String name) {
        this.name = name;
        this.persons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }
}
