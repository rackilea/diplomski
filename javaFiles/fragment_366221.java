@Select("SELECT * FROM STUDENTS WHERE STUD_ID=#{studId}")
@Results({
  @Result(id=true, column="stud_id", property="studId"),
  @Result(column="name", property="name"),
  @Result(column="email", property="email"),
  @Result(column="addr_id", property="address.addrId")
})
Student findStudentById(int studId);

@Select("SELECT * FROM STUDENTS")
@Results({
  @Result(id=true, column="stud_id", property="studId"),
  @Result(column="name", property="name"),
  @Result(column="email", property="email"),
  @Result(column="addr_id", property="address.addrId")
})
List<Student> findAllStudents();