public abstract class DaoTemplate
{
  public void execute() {
    final Session s = ((SessionFactory) ServletActionContext.getServletContext()
        .getAttribute(HibernateListener.KEY_NAME)).openSession();
    try {
      s.beginTransaction();
      doTheRealStuff();
      s.getTransaction().commit();
    }
    catch(Exception e) {
      s.getTransaction().rollback();
      e.printStackTrace();
    } finally { s.close(); }
  }

  protected abstract void doTheRealStuff();
}