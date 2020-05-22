`public void deleteStudentsPersistence(Student student) {
    Student managedEntity = em.find(Student.class, student.getId());
    em.remove(managedEntity);
   // em.remove(em.contains(student) ? student : 
   // em.merge(student));
}`