Query query = session.createQuery(query);
List<Object[]> listResult = query.list();

for (Object[] aRow : listResult) {
    Subject subject = (Subject) aRow[0];
    Student student = (Student) aRow[1];
    //do your code
}