public void addStudent(Student student) {
    if (CURRENT_POSITION < CAPACITY) {
        students[CURRENT_POSITION] = student;
        CURRENT_POSITION++;
    }
}