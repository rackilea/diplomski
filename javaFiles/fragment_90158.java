Query qry=session.createQuery("from Main");
    List<Main> user=(List<Main>) qry.list();
    session.getTransaction().commit();

    session.close();
    for(Main u : user)
    {
        System.out.println("User id : "+u.getEmpid());
        System.out.println("User Address:"+u.getAddress());
    }