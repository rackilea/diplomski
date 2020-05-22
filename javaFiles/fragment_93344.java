test=new TestingObject();

    test.setName((String) tablemanage.getModel().getValueAt(i,0));
    test.setAge((String) tablemanage.getModel().getValueAt(i,1));
    test.setGender((String) tablemanage.getModel().getValueAt(i,2));

    testList.add(test);