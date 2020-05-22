try{
            session=HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            for(int i=0;i<companies.size();i++)
            {   
                // THIS IS BAD 
                //Company com=new Company();
                //You need this
                Company com = companies.get(i);
                session.saveOrUpdate(com);
            }
            transaction.commit();
            status++;

        }