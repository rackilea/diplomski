private List<?> winners;    

try {           
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session hSession = factory.openSession();
    Transaction tx = null;

        try {

            tx = hSession.beginTransaction();
            winners = hSession.createSQLQuery("from usertable u, resulttable r where u.id = r.id and r.ispassed = true").list();
            tx.commit();

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            hSession.close();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.println(winners.size());