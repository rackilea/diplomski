@Override
public void add(SomeEntity instance) {
   try {
       TransientInterceptor.set(true);
       sessionFactory.getCurrentSession().save(instance);
   }
   finally {
      TransientInterceptor.set(false);   
   }
}