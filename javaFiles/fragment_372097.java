public void delete(long id)
{
    Session session ;
    MyObject myObject ;

    session = sessionFactory.getCurrentSession();
    myObject = (MyObject)session.load(MyObject.class,id);
    session.delete(myObject);

    //This makes the pending delete to be done
    session.flush() ;

}