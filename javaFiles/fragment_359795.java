server.beginTransaction();
try {
   // persistence context scoped to transaction so 
   // .. now spans both fetches giving John and Lizz
   // .. the same shared Club instance
   john = server.find(Student.class).where().ieq("name", "john").findUnique();
  lizz = server.find(Student.class).where().ieq("name", "lizz").findUnique();
} finally {
  server.endTransaction();
}