@Service
public class ContentService {
  private List<Category> categories = new ArrayList<>();

  public List<Category> getAllContent() {
    List<Course> courses = new ArrayList<>();
    courses.add(new Course(1, "Coursename", 200, 200, 1001));

    List<Category> categories = new ArrayList<>();
    categories.add(new Category(1001, "Computing", "network of remote servers", courses));
    return categories;
  }
}