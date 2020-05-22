public class ClassesBean {
    private long id;
    private int classes_item_index;
    private String classes_name;
    private String classes_codename;
    private String classes_sections;
    private String classes_teachers;
    private String classes_students;

    public int getClasses_item_index() {
        return classes_item_index;
    }

    public void setClasses_item_index(int classes_item_index) {
        this.classes_item_index = classes_item_index;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClasses_name() {
        return classes_name;
    }

    public void setClasses_name(String classes_name) {
        this.classes_name = classes_name;
    }

    public String getClasses_codename() {
        return classes_codename;
    }

    public void setClasses_codename(String classes_codename) {
        this.classes_codename = classes_codename;
    }

    public String getClasses_sections() {
        return classes_sections;
    }

    public void setClasses_sections(String classes_sections) {
        this.classes_sections = classes_sections;
    }

    public String getClasses_teachers() {
        return classes_teachers;
    }

    public void setClasses_teachers(String classes_teachers) {
        this.classes_teachers = classes_teachers;
    }

    public String getClasses_students() {
        return classes_students;
    }

    public void setClasses_students(String classes_students) {
        this.classes_students = classes_students;
    }
}