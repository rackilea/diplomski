public class Students {
    private final Map<Integer, String> map = new LinkedHashMap();

    public void put(int num, String str) { map.put(num, str); }

    public String get(int num) { return map.get(num); }

    public static void main(String args[]) { 
        Students students = new Students(); 
        students.put(1, "s1");
        students.put(2, "s2");
        students.put(3, "s3");

        System.out.println(students.get(1));
    }
}