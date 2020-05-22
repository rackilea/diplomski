Session ses = HibernateUtil.getSessionFactory().openSession();
  String query = "SELECT review.comment FROM ReviewDO review WHERE title=:title";
  List<ReviewComment> reviewComments = ses.createQuery(query)
  .setParameter("title", "Can't beat the product")
  .list();
  ses.close();