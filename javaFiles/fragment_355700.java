public class TestEquality3 {
    public static void main(String[] args) {
        Employee emp = new Employee("John", "Doe");
    }

    private static class Employee {
        private String firstName;
        private String lastName;

        public Employee(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}