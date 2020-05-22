public List getStudentSchedule(int a) {
     Session sessionHb = session.openSession();
     String sql = "select stud.firstname,stud.roll,sub.subjectname,cls.classname,exam.exam_name,exam.from_time,exam.to_time,exam.exam_date from Student stud,Subject sub,Classs cls,Exam exam where exam.classs=cls.id and exam.subject=sub.id and sub.classs=cls.id and stud.classs=cls.id and stud.roll= :roll";
     SQLQuery query = sessionHb.createSQLQuery(sql);
     query.setParameter("roll", a);
     query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
     return query.list();
}