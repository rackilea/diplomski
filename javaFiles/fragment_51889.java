import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonProgram {

    public static void main(String[] args) throws IOException {
        Person person = new Person();
        person.setId(1L);
        person.setName("Max");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(Person.class, PersonMixIn.class);

        System.out.println(objectMapper.writeValueAsString(person));
    }
}

abstract class Entity {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

interface Namamble {
    String getName();
}

class Person extends Entity implements Namamble {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface PersonMixIn {
    @JsonIgnore
    String getName();
}