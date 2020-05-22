import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class CsvApp {

    public static void main(String[] args) throws Exception {
        File csvFile = new File("./resource/test.csv").getAbsoluteFile();

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);

        MappingIterator<List<String>> rows = csvMapper.readerFor(List.class).readValues(csvFile);
        List<Person> persons = rows.readAll().stream()
                .filter(row -> !row.isEmpty())
                .map(Person::new)
                .collect(Collectors.toList());

        persons.forEach(System.out::println);
    }
}

class Person {

    private String name;
    private List<String> contacts;

    public Person(List<String> row) {
        this.name = row.remove(0);
        this.contacts = row;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}