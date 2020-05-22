public class TradeService {

        Configuration configuration = null;
        //StandardServiceRegistryBuilder ssrb = null;
        SessionFactory sessionFactory =  null;
        Session session = null;

        private void init() {
            configuration = new Configuration().configure("hibernate.cfg.xml");
            //ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
        }

        public List<TradeMessage> getTradeMessages(TradeMessageFilterBean filterBean){
            List<TradeMessage> queryResult = new ArrayList<>();

            try {

                if(session == null) this.init();

                TradeMessage trademessage = new TradeMessage(654321);

                session = sessionFactory.openSession();
                session.beginTransaction();

                //C
                session.save(trademessage);
                //R
                TradeMessage newTM = (TradeMessage) session.get(TradeMessage.class, 1);
                System.out.println("TM = : " + newTM.toString());
                //U
                newTM.setId(100);
                session.update(newTM);
                newTM = (TradeMessage) session.get(TradeMessage.class, 1);
                System.out.println("TM = : " + newTM.toString());
                //D
                session.delete(newTM);

                session.getTransaction().commit();
                session.close();
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
            }

            return queryResult; 
        }