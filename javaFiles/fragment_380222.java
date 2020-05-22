final Result<Record<Integer,String,String,String>> ret = context
        .select(Student.STUDENT.ID,
                Student.STUDENT.NAME,
                Address.ADDRESS.STREET,
                Hobby.HOBBY.NAME)
        .from(Student.STUDENT)
        .join(Hobby.HOBBY)
        .on(Student.STUDENT.ID.eq(Hobby.HOBBY.STUDENT_ID))
        .join(Address.ADDRESS)
        .on(Student.STUDENT.ADDRESS_ID.eq(Address.ADDRESS.ID))
        .where(Student.STUDENT.GRADE.eq(10))
        .orderBy(Student.STUDENT.NAME.asc())
        .fetch();
Integer lastStudentId = null;
for (final Record<Integer,String,String,String> val : ret) {
    final Integer studentId = val.getValue(Student.STUDENT.ID,);
    if (!studentId.equals(lastStudentId)) {
        System.out.println("Student " + val.getValue(Student.STUDENT.NAME)
                + " who lives on " + val.getValue(Address.ADDRESS.STREET)
                + " street has hobbies:"
        );
    }
    lastStudentId = studentId;
    System.out.println("\t" + val.getValue(Hobby.HOBBY.NAME));
}