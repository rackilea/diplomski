class course {

        String name;
        int number;
        int credit;
        String grade;
    }

    class student {

        String name;
        String id;
        int numberCourses;
        course[] courses;
    }

    class ParseStore {

        student[] students;

        void initStudent(int len) {
            for (int i = 0; i < len; i++) {
                students[i] = new student();
            }
        }

        void initCourse(int index, int len) {
            for (int i = 0; i < len; i++) {
                students[index].courses[i] = new course();
            }
        }

        void parseFile() throws FileNotFoundException, IOException {
            FileInputStream fstream = new FileInputStream("test.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            int numberStudent = Integer.parseInt(br.readLine());
            students = new student[numberStudent];
            initStudent(numberStudent);

            for (int i = 0; i < numberStudent; i++) {

                String line = br.readLine();
                int numberCourse = Integer.parseInt(line.split(" ")[2]);
                students[i].name = line.split(" ")[0];
                students[i].id = line.split(" ")[1];
                students[i].numberCourses = numberCourse;
                students[i].courses = new course[numberCourse];
                initCourse(i, numberCourse);

                for (int j = 0; j < numberCourse; j++) {
                    line = br.readLine();
                    students[i].courses[j].name = line.split(" ")[0];
                    students[i].courses[j].number = Integer.parseInt(line.split(" ")[1]);
                    students[i].courses[j].credit = Integer.parseInt(line.split(" ")[2]);
                    students[i].courses[j].grade = line.split(" ")[3];
                }
            }                        
        }
    }