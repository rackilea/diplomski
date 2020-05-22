Just use Object the hibernate will persist it.


public void makePersistent(Object model) throws InfrastructureException {
         try {
            getSession().saveOrUpdate(model);
            getSession().flush();
            getSession().clear();
        } catch (org.hibernate.StaleObjectStateException ex) {
            throw new InfrastructureException(Labels.getString("com.tran.msg.objectDeletedOrUpdaed"));
        } catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
    }