SessionFactory factory= HibernateUtil.getSessionFactory();  
    session = factory.openSession();  
    session.beginTransaction();  
    Query query = session.createQuery("Select c.productList from Cart c Where c.cartId=:cartId"); 
    query.setParameter("cartId", cart.getCartId());
    List productList=(List) query.list();
    session.getTransaction().commit();