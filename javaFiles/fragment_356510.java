public static ArrayList<Course> getCoursesByTeacher(Teacher teacher){
    ArrayList<Course> courses = new ArrayList<Course>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Object> list = session.createQuery("select c from Course c join c.teacherCourses tc where tc.teacher = :teacher")
            .setParameter("teacher", teacher).list();
    session.getTransaction().commit();
    session.close();
    for(Object o : list){
        courses.add((Course) o);
    }
    return courses;
}