e1 = session1.load(key);
e2 = session2.load(key);
e2.modifyAnything();
e2.update();
e2.commit();
e1.modifyAnything();
e1.update();