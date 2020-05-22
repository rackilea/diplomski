public interface CourseRepositoryInterface {
     void addCourse(Course course);
     void deleteCourse(Course course);
     void updateCourse(Course course);

     List<Course> getAllCourses();
}