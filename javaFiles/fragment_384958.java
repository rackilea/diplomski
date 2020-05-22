public void print() {

        System.out.println("ID: " + ID);

        System.out.println("\nExams done: ");

        for (Exam exam : exams) {
            System.out.println(exam);
        }

    }