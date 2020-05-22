public class JacksonConvertion {
    public static void main(String[] args) {

        pojoToJson();
        jsonToPojo();

    }

    private static void pojoToJson() {
        try {
            System.out.println("Convert Object to json ");
            ObjectMapper mapper = new ObjectMapper();

            Address address = new Address("#103, 1st cross, manyta tech park", "Bengaluru", "Karnataka", "560010",
                    "India");

            Address address1 = new Address();
            address1.setCity("Bengaluru");
            address1.setState("Karnataka");
            address1.setCountry("India");

            Employee emp = new Employee(1233, "Raju", "BG", 98734.23, address1);

            mapper.writeValue(new File("staff.json"), emp);

            String jsonString = mapper.writeValueAsString(emp);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void jsonToPojo() {
        try {
            System.out.println("Convert Json to Object ");
            ObjectMapper mapper = new ObjectMapper();
            Employee employee = mapper.readValue(new File("staff.json"), Employee.class);

            System.out.println(employee.getFirstName());
            System.out.println(employee.getSalary());

            System.out.println(employee.getAddress().getCity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}