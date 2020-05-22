public static void main(final String[] args) throws Exception {

        Session session = ourSessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Engine engineRight1 = new Engine("engineRight1", (byte) 1);
            Engine engineLeft1 = new Engine("engineLeft1", (byte) 0);
            Airplane airplane1 = new Airplane("Airplane1");

            Engine engineRight2 = new Engine("engineRight2", (byte) 1);
            Engine engineLeft2 = new Engine("engineLeft2", (byte) 0);
            Airplane airplane2 = new Airplane("Airplane2");

            Engine engineRight3 = new Engine("engineRight3", (byte) 1);
            Engine engineLeft3 = new Engine("engineLeft3", (byte) 0);
            Airplane airplane3 = new Airplane("Airplane3");

            engineLeft1.setOwnerAirplane(airplane1);
            engineRight1.setOwnerAirplane(airplane1);
            airplane1.setLeftEngine(engineLeft1);
            airplane1.setRightEngine(engineRight1);

            engineRight2.setOwnerAirplane(airplane2);
            airplane2.setRightEngine(engineRight2);
//            airplane2.setLeftEngine(engineLeft1);

            engineRight3.setOwnerAirplane(airplane3);
            airplane3.setLeftEngine(engineLeft3);

            session.save(airplane1);
            session.save(airplane2);
            session.save(airplane3);

            session.save(engineLeft1);
            session.save(engineLeft2);
            session.save(engineLeft3);
            session.save(engineRight1);
            session.save(engineRight2);
            session.save(engineRight3);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }