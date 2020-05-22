public class Launcher {

    public static void main (String ... args){

        List<Student> stList = new ArrayList<Student>();
        stList.add(new Student("name1", 7));
        stList.add(new Student("name3", 6));
        stList.add(new Student("name1", 5));
        stList.add(new Student("name1", 5));
        stList.add(new Student("name1", 1));
        stList.add(new Student("name1", 10));
        stList.add(new Student("name1", 2));
        stList.add(new Student("name1", 9));
        stList.add(new Student("name1", 4));
        Set<Student> stSet= new HashSet<Student>(stList);
    }
}