// We retrieve a stub user for given id. There is no interaction with DB
User user = em.getReference("someId", User.class);

UserOperation uOp = new UserOperation();
uOp.setUser(user);
uOp.setSomeString("just op");
em.persist(uOp);