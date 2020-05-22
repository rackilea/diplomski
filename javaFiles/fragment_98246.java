SessionFactory sf = null;
Session s = null;
SessionHolder holder = null;

@Override
protected void onSetUp() throws Exception {
     System.out.println("On SetUP----");
     sf = (SessionFactory) beanFactory.getBean("sessionFactory");
     s = sf.openSession();
     TransactionSynchronizationManager.bindResource(sf, new SessionHolder(s));
} 

@Override
protected void onTearDown() throws Exception {
     System.out.println("On onTearDown----");
     // unbind and close the session.
     holder = (SessionHolder)TransactionSynchronizationManager.getResource(sf);
     s = holder.getSession();
     s.flush(); 
     TransactionSynchronizationManager.unbindResource(sf);
     SessionFactoryUtils.releaseSession(s, sf);
     // teardown code here
}