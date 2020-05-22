@PreRemove
private void preRemove() {
    for (Student s : studentList) {
        s.setTeacher(null);
    }
}