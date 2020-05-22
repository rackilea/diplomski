import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PersonGroupByExample {

    public static void main(String[] args) {

        final List<Map<String, Object>> input = Arrays.asList(
                new HashMap<String, Object>(){{
                    put("userId", "user1");
                    put("firstName", "John");
                    put("lastName", "Smith");
                    put("courses", "course1");
                }},
                new HashMap<String, Object>(){{
                    put("userId", "user1");
                    put("firstName", "John");
                    put("lastName", "Smith");
                    put("courses", "course2");
                }},
                new HashMap<String, Object>(){{
                    put("userId", "user1");
                    put("firstName", "John");
                    put("lastName", "Smith");
                    put("courses", "course3");
                }},
                new HashMap<String, Object>(){{
                    put("userId", "user2");
                    put("firstName", "Jack");
                    put("lastName", "Smith");
                    put("courses", "course1");
                }},
                new HashMap<String, Object>(){{
                    put("userId", "user2");
                    put("firstName", "Jack");
                    put("lastName", "Smith");
                    put("courses", "course2");
                }}
        );

        final Collection<Person> result = input.stream()
                .parallel()
                .collect(Collectors.groupingBy(it -> it.get("userId"), Collector.of(
                        // Start with an empty Person object
                        Person::new,
                        // Collect a list of map objects grouped by the same userId into a single Person object
                        (person, map) -> {
                            // Override common properties
                            person.setUserId(map.getOrDefault("userId", "").toString());
                            person.setFirstName(map.getOrDefault("firstName", "").toString());
                            person.setLastName(map.getOrDefault("lastName", "").toString());
                            // Add person's course to a courses set
                            person.getCourses().add(new Course(map.getOrDefault("courses", "").toString()));
                        },
                        // Combiner function that join partials results (for parallel execution)
                        (person, person2) -> {
                            person.getCourses().addAll(person2.getCourses());
                            return person;
                        }
                ))).values();

        result.forEach(System.out::println);
    }


    static class Person {
        String userId;
        String firstName;
        String lastName;
        Set<Course> courses = new HashSet<>();

        public Person() {}

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Set<Course> getCourses() {
            return courses;
        }

        public void setCourses(Set<Course> courses) {
            this.courses = courses;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "userId='" + userId + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", courses=" + courses +
                    '}';
        }
    }

    static class Course {
        String id;

        public Course(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }
}