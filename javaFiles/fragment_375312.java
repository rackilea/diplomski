public class Groups extends RealmObject {
    private String id;
    private String grade;
    private String group;
    private RealmList<Students> students;
}