Student student = new Student();
student.setName("Student 1");
student.setAge(18);

Teacher teacher = new Teacher();
teacher.setName("Teacher 1");

Sclass sclass = new Sclass();
sclass.setStudent(student);
sclass.setTeacher(teacher);

Gson gson = new Gson();
String json = gson.toJson(sclass);

System.out.println(json);