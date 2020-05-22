//no need to select your object before you delete it
//Query query = session.createQuery("from vi where name=" + name);
//Teacher teacher=(Teacher)session.get(Teacher.class, name);
//Teacher teacher = (Teacher) query.getSingleResult();

//just make a delete query directly
String hql = "DELETE FROM vi WHERE name= :name";
Query query = session.createQuery(hql);
query.setParameter("name", name);
int result = query.executeUpdate();