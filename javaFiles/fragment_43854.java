public class Student {
    private String firstName;
    private String lastName;
    private List<String> fileNames;
    private int section;
    private int date; // Consider changing this to a different type
    public Student(String firstName, String lastName, int section, int date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
        this.date = date;
        fileNames = new ArrayList<String>();
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getSection() { return section; }
    public int getDateSubmitted() { return date; }
    public List<String> getFileNames() { return fileNames; }
}