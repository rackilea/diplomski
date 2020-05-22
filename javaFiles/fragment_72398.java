@Test(expected = org.hibernate.exception.ConstraintViolationException.class)  
public void testUniqueEmail() throws DaoException{
    User uri = new User("uri","naor","a@b.com");
    userDao.saveUser(uri);
    User clone = new User("clone","wars","a@b.com");
    userDao.saveUser(clone);
    try{
        sessionFactory.getCurrentSession().flush();
    }catch(org.hibernate.exception.ConstraintViolationException ex){
        sessionFactory.getCurrentSession().clear();
        SQLException ex1= new SQLException();
        throw new ConstraintViolationException("Could not insert",ex1,"what else");
    }
}