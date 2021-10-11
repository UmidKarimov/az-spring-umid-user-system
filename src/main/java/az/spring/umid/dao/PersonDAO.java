package az.spring.umid.dao;


import az.spring.umid.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNTER = 0;

    private List<Person> people;

    {
        people = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            people.add(new Person(++PEOPLE_COUNTER, "Person No" + PEOPLE_COUNTER));
        }
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save (Person person){
        person.setId(++PEOPLE_COUNTER);
        people.add(person);
    }

}
