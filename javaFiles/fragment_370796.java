public void saveEmployee(Employee e) {
    Session s = sf.getCurrentSession();    
    s.getTransaction().begin();
    s.save(e);    
    s.getTransaction().commit();
}