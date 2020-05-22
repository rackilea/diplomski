public static class Student {

        private final String name;

        private final int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return String.format("name=%s, id=%s", name, id);
        }
    }

    public static class School {

        private final List<Student> students;

        public School(List<Student> students) {
            this.students = students;
        }

        public void add(Student student) {
            students.add(student);
        }

        public List<Student> getStudents() {
            return students;
        }
    }

    public static void main(String... args) {
        School school = new School(new ArrayList<>());

        school.add(new Student("jason", 1));
        school.add(new Student("jonny", 2));

        school.getStudents().forEach(System.out::println);
    }