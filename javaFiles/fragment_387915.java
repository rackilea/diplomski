ClassRoom classRoom = /* comes from somewhere */;
List<Student> students = classRoom.getStudents();

// Aggregate all the typeIds.
Multiset<Long> typeIds = HashMultiset.create();
for (Student student : students) {
    // Assuming a student doesn't have duplicated typeIds:
    typeIds.addAll(student.getTypeIds());
}

// Find which typeIds are present for all the students.
for (Multiset.Entry<Long> entry : typeIds.entrySet()) {
    if (entry.getCount() == students.size()) {
        System.out.println(entry.getElement());
    }
}