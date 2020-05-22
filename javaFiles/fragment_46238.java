Derogation derogation = new Derogation();
derogation.setApplication(new Application());
derogation.getApplication().setNom("applicationName");

Criteria criteria = session.createCriteria(Derogation.class);
criteria.add(Example.create(derogation));

//For the ManyToOne child
criteria.createCriteria("application").add(Example.create(derogation.getApplication()));

//For the OneToMany child
for(DerogationLinux derogationLinux : derogation.getListDerogationLinux())
    criteria.createCriteria("listDerogationLinux").add(Example.create(derogationLinux));