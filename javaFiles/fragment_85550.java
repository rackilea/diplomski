public class CarCategoryHome {

        private final SessionFactory sessionFactory = getSessionFactory();

        protected SessionFactory getSessionFactory() {
            try {
                return EntityHome.getInstance().getSessionFactory();
            } catch (NamingException e) {
                AppLogger.Log(e);
                return null;
            }
        }

        public CarCategory findById(Integer id) {
            try {
                CarCategory instance = (CarCategory) sessionFactory.getCurrentSession()
                        .get("com.myapp.data.CarCategory", id);
                return instance;
            } catch (RuntimeException re) {
                throw re;
            }
        }

    }