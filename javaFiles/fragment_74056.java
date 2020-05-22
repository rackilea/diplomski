import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUpdate {

    public static final String LAST_STUDENT_LINE = "LASTSTUDENTEENTRYLINENNAMES";

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(128);
        List<Student> objectInputFieldsList = new ArrayList<>(25);
        objectInputFieldsList.add(new Student(128, "Banana", "Pajamas"));

        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader("test.txt"));
            String text = null;
            while ((text = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(text);
            }

            System.out.println("Before");
            System.out.println(sb);

            for (Student s : objectInputFieldsList) {

                int insertIndex = sb.indexOf(LAST_STUDENT_LINE);
                StringBuilder line = new StringBuilder(128);
                line.append(s.getId()).append(" | ").append(s.getFirstName()).append(" | ").append(s.getLastName()).append("\n");
                sb.insert(insertIndex, line.toString());

                // Find subject mark and add the students subjects in as well...

            }

            System.out.println("\nAfter");
            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException exp) {
            }
        }

    }

    public static class Student {

        private int id;
        private String firstName;
        private String lastName;

        public Student(int id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }            
    }
}