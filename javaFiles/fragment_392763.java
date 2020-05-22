public class Main {

    public static void main(String[] args) {

        Gson gson = new Gson();

        Map<String, ArrayList<Salary>> sal = new HashMap<String, ArrayList<Salary>>();
        ArrayList<Salary> salaries = new ArrayList<Salary>();
        Salary salary1 = new Salary("100", "€");
        Salary salary2 = new Salary("200", "€");
        salaries.add(salary1);
        salaries.add(salary2);
        sal.put("1", salaries);
        Employee employee = new Employee(sal, "Test", "12");

        System.out.println("Age -> " + employee.getAge());
        System.out.println("Name -> " + employee.getName());
        System.out.println("Salary -> " + employee.getSalary());

        String json = gson.toJson(employee);
        System.out.println("Json -> " + json);

        Employee employee1 = gson.fromJson(json, Employee.class);

        System.out.println("Age1 -> " + employee1.getAge());
        System.out.println("Name1 -> " + employee1.getName());
        System.out.println("Salary1 -> " + employee1.getSalary());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Employee{

        Map<String, ArrayList<Salary>> salary = new HashMap<String, ArrayList<Salary>>();
        String name;
        String age;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Salary{
        String amount;
        String currency;

    }
}