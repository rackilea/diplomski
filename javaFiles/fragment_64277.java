uow=sess.acquireUnitOfWork();
for (job in batch) {
 thingyCl=uow.registerObject(new Thingy());
 user1Cl=uow.registerObject(user1);
 user2Cl=uow.registerObject(user2);
 thingyCl.setUsers(user1Cl,user2Cl);
}
uow.commit();