import java.util.ArrayList;
import java.util.function.Predicate;

class Course {

    float percentage;
    char courseLevel;
    String courseName;
    boolean takingNow;

    public static ArrayList<Course> allCourses;

    public ArrayList<Course> getCourses(Predicate<Course> coursePredicate) {
        ArrayList<Course> toReturn = new ArrayList<>();
        for (Course c : allCourses
                            .stream()
                            .filter(coursePredicate)
                            .toArray(Course[]::new)) {
            toReturn.add(c);
        }
        return toReturn;
    }
}