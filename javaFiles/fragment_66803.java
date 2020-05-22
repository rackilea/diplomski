public class JacksonReferences {

    @JsonIdentityInfo(generator = ObjectIdGenerators.None.class, property = "id")
    static public class Company {
        public Integer id;
        public String name;
        @JsonManagedReference
        public Collection<Employee> employees;

        public Company(Integer id, String name, Collection<Employee> employees) {
            this.id = id;
            this.name = name;
            this.employees = employees;
        }
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.None.class, property = "id")
    static public class Employee {
        public Integer id;
        public String name;
        @JsonBackReference
        public Company company;

        public Employee(Integer id, String name, Company company) {
            this.id = id;
            this.name = name;
            this.company = company;
        }
    }


    public static void main(String[] args) throws IOException {
        Company company1 = new Company(1, "Microsoft", new ArrayList<Employee>());
        Company company2 = new Company(2, "Google", new ArrayList<Employee>());

        Employee employee1 = new Employee(1, "John", company1);
        company1.employees.add(employee1);
        Employee employee2 = new Employee(2, "Tim", company1);
        company1.employees.add(employee2);
        Employee employee3 = new Employee(3, "Bob", company2);
        company2.employees.add(employee3);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println("JSON for company #1:");
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(company1));
        System.out.println("JSON for employee #1:");
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1));
        System.out.println("JSON for company #2:");
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(company2));
    }
}