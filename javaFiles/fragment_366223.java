public interface StudentMapper

@Select("SELECT * FROM STUDENTS WHERE STUD_ID=#{studId}")
@ResultMap("com.mybatis3.mappers.StudentMapper.StudentResult")
Student findStudentById(int studId);

@Select("SELECT * FROM STUDENTS")
@ResultMap("com.mybatis3.mappers.StudentMapper.StudentResult")
List<Student> findAllStudents();