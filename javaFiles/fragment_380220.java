final List<StudentRecord> students = context.selectFrom(Student.STUDENT)
       .where(Student.STUDENT.GRADE.eq(10))
       .fetchInto(StudentRecord.class);
for (final StudentRecord student : students) {
    student.setName("some other name");
}
context.batchStore(students).execute();