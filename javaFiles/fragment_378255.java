Brand brand = new Brand();

brand.setName("test");
brand.setUrl("http://www.google.com");

AnnotationConfiguration c = new AnnotationConfiguration();
c.addAnnotatedClass(Brand.class);
c.configure();

Session ses = c.buildSessionFactory().getCurrentSession();

Transaction t = ses.beginTransaction();
ses.save(brand);
t.commit();