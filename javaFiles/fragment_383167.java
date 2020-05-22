EntityTransaction tr = em.getTransaction();

tr.begin();

for (int j = 1; j < 10; j++) {
    Student student = new Student("Student name " + j);
    for (int i = 1; i <= 10; i++) {
        student.getBooks().add(new Book("Some book" + i, student));
    }
    em.persist(student);
}

tr.commit();