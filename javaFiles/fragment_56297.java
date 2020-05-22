public class Test {

    private Map<String, Integer> employeeNameToAgeMap = new HashMap<String, Integer>();

    public int getAge(String employeeName) {
        final Integer age = employeeNameToAgeMap.get(employeeName);
        if (age == null) {
            age = getAgeFromSomeCustomAPI(employeeName);
            employeeNameToAgeMap.put(employeeName, age);
        }
        return (int)age;
    }
}