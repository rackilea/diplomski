Session hSession = sessionService.openSession();
Parent parent = hSession.get(Parent.class, parentId);

Child child = new Child();
child.setName = "CooCoo";

parent.setChild(child);
child.setParent(parent);
parentRepo.update(parent, hSession);
hSession.close();