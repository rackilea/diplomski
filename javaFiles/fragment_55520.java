import java.util.*;
import java.io.*;

public class test1 {
    static class Student {
        String id;
        String name;
        List<Double> marks;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
            marks = new ArrayList<Double>();
        }
        public void addMark(Double d) {
            marks.add(d);
        }
        public void writeToPW(PrintWriter out) {
            out.println(id + " " + name);
            double d = 0;
            for (int i = 0; i < marks.size(); i++) {
                out.printf("Marks%d: %.2f ", (i+1), marks.get(i));
                d += marks.get(i);
            }
            out.println("AverageMark: " + d / marks.size());
            out.println("- - - - - -");    
        }
    }
    public static void main(String[] args) throws IOException {
        //declare reader and writer
        BufferedReader reader = null;
        PrintWriter writer = null;

        //hash maps to store the data
        HashMap<String, Student> students = new HashMap<String, Student>();

        // list to maintain the original order
        List<Student> orderedStudents = new ArrayList<Student>();


        //read the  first file and store the data
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("IRStudents.txt"))));
        String line;
        String[] arg;
        while ((line = reader.readLine()) != null) {
            if (!line.startsWith("-")) {
                arg = line.split(" ");
                Student student = new Student(arg[0], arg[1]);
                students.put(arg[0], student);
                orderedStudents.add(student);
            }
        }
        reader.close();


        reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("IR101.txt"))));
        while((line = reader.readLine()) != null){
            arg = line.split(" ");
            students.get(arg[0]).addMark(Double.parseDouble(arg[1]));
        }


        reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("IR102.txt"))));
        while((line = reader.readLine()) != null){
            arg = line.split(" ");
            students.get(arg[0]).addMark(Double.parseDouble(arg[1]));
        }

        // Now we can do writing.
        writer = new PrintWriter(new FileOutputStream(new File("File_2.txt")));
        for (Student s: orderedStudents) {
            s.writeToPW(writer);
        }
        writer.close();
    }
}