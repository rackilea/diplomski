Object obj = new Object();
    obj.setId(1);
    obj.setName("Employee");
    sess.save(obj);

    ObjectAttribute ageAtt = new ObjectAttribute();
    ageAtt.setId(1);
    ageAtt.setName("age");
    ageAtt.setObject(obj);
    sess.save(ageAtt);

    ObjectAttribute depAtt = new ObjectAttribute();
    depAtt.setId(2);
    depAtt.setName("department");
    depAtt.setObject(obj);
    sess.save(depAtt);

    ObjectAttribute attName = new ObjectAttribute();
    attName.setId(3);
    attName.setName("name");
    attName.setObject(obj);
    sess.save(attName);