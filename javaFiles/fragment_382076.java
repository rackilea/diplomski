public void updateSessionStatus() {
        Session sess = factory.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            Criteria crit = sess.createCriteria(CollegeStudentsMaster.class);
            crit.add(Restrictions.eqProperty("academicYear", "courseYears"));
            // Here is updated code
            ScrollableResults items = crit.scroll();
            int count=0;
            while ( items.next() ) {
                CollegeStudentsMaster e = (CollegeStudentsMaster)items.get(0);
                e.setSessionStatus("G");
                sess.saveOrUpdate(e);
                if ( ++count % 100 == 0 ) {
                    sess.flush();
                    sess.clear();
                }
            }
            tx.commit();
        } catch (HibernateException asd) {
            if (tx != null) {
                tx.rollback();
            }
            log.debug(asd.getMessage());
        } finally {
            sess.close();
        }
    }