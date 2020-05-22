@PostMapping("pc/{id}/")
public String addCharact(HttpServletRequest req){
  String name = req.getParameter("name");
  String value = req.getParameter("value");
  String id = req.getParameter("id");
  PcChars pcchars = new PcChars(name,value,id); // create the corresponding constructor
  SessionFactory sessionFactory;
  Session session = sessionFactory.openSession();
  Transaction tx = null;
    try{
        tx = session.getTransaction();
        tx.begin();
        session.save(pcchars);
        tx.commit();
    }
    catch (HibernateException e) {
        if (tx!=null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
  return "charList";
}