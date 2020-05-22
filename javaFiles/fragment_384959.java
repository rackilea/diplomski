public void print() {

    System.out.println("ID: " + ID);

    System.out.println("\nExams done: ");

    Iterator<Exam> es = exams.iterator();

    while (es.hasNext()) {
        System.out.println(es.next());
    }
}