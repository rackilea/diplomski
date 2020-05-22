public void writeParent(Parent parent) {
    tempParent = new Parent();
    tempParent.setFirstChild(checkChild(tempParent.getFirstChild()));
    tempParent.setSecondChild(checkChild(tempParent.getSecondChild()));
    globalSession = getSessionFactory().openSession();
    globalSession.beginTransaction();
    globalSession.saveOrUpdate(tempParent);
    globalSession.getTransaction().commit();
    globalSession.close();
}