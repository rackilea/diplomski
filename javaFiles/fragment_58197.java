public Notification popAndRemove(){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    Notification notification = session.createCriteria(Notification.class)
        .uniqueResult();    

    Notification newNotification = new Notification(notification);

    session.delete(notification);
    return newNotification;
}