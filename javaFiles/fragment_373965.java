import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroupByTest {

    public static void main(String[] args) {
        final List<Man> people = Arrays.asList(
                new Man(1, "John", "Doe", 20, 0, new Address(new Country("England"), new City("London"), "Test Street 2", 10000)),
                new Man(2, "Mary", "Smith", 54, 4, new Address(new Country("Germany"), new City("Berlin"), "Maine Strasse 32", 10000)),
                new Man(3, "James", "Rose", 13, 0, new Address(new Country("England"), new City("London"), "Test Street 2", 10000)),
                new Man(4, "Vincent", "Dog", 43, 2, new Address(new Country("Germany"), new City("Berlin"), "Volkswagen Platz 31", 10000)),
                new Man(5, "Arnold", "Smoke", 72, 3, new Address(new Country("Italy"), new City("Rome"), "Pepperoni 31", 10000)),
                new Man(6, "Katy", "Puppet", 33, 3, new Address(new Country("England"), new City("London"), "Test Street 3", 10000))
        );

        final Map<Map.Entry<City, String>, List<Man>> groupedByCityAndStreet = people.stream()
                .collect(Collectors.groupingBy(
                        man -> new AbstractMap.SimpleEntry<>(man.getAddress().getCity(), man.getAddress().getStreet()),
                        Collectors.toList()
                ));

        // Print people associated with given city and street to console
        groupedByCityAndStreet.forEach((k, v) -> {
            System.out.println("People associated with " + k.getKey().name + ", " + k.getValue() + ":");
            v.forEach(man -> {
                System.out.println(man);
            });
        });
    }

    static final class Man {
        private final int id;
        private final String firstName;
        private final String lastName;
        private final int age;
        private final int countOfChildren;
        private final Address address;

        public Man(int id, String firstName, String lastName, int age, int countOfChildren, Address address) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.countOfChildren = countOfChildren;
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public int getCountOfChildren() {
            return countOfChildren;
        }

        public Address getAddress() {
            return address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Man man = (Man) o;
            return id == man.id &&
                    age == man.age &&
                    countOfChildren == man.countOfChildren &&
                    Objects.equals(firstName, man.firstName) &&
                    Objects.equals(lastName, man.lastName) &&
                    Objects.equals(address, man.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, firstName, lastName, age, countOfChildren, address);
        }

        @Override
        public String toString() {
            return "Man{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", countOfChildren=" + countOfChildren +
                    ", address=" + address +
                    '}';
        }
    }

    static class Address {
        private final Country country;
        private final City city;
        private final String street;
        private final long quantityOfPeople;

        public Address(Country country, City city, String street, long quantityOfPeople) {
            this.country = country;
            this.city = city;
            this.street = street;
            this.quantityOfPeople = quantityOfPeople;
        }

        public Country getCountry() {
            return country;
        }

        public City getCity() {
            return city;
        }

        public String getStreet() {
            return street;
        }

        public long getQuantityOfPeople() {
            return quantityOfPeople;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return quantityOfPeople == address.quantityOfPeople &&
                    Objects.equals(country, address.country) &&
                    Objects.equals(city, address.city) &&
                    Objects.equals(street, address.street);
        }

        @Override
        public int hashCode() {

            return Objects.hash(country, city, street, quantityOfPeople);
        }

        @Override
        public String toString() {
            return "Address{" +
                    "country=" + country +
                    ", city=" + city +
                    ", street='" + street + '\'' +
                    ", quantityOfPeople=" + quantityOfPeople +
                    '}';
        }
    }

    static class City {
        private final String name;

        public City(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            City city = (City) o;
            return Objects.equals(name, city.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Country {
        private final String name;

        public Country(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Country country = (Country) o;
            return Objects.equals(name, country.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Country{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}