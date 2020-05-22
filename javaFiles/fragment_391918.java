if (action.equals("Display Employee")) {
    List<Object[]> list = new ArrayList<Object[]>();
    for (int i = 0; i < empArray.size(); i++) {
        list.add(new Object[] { 
                                  empArray.get(i).getFName(), 
                                  empArray.get(i).getLName(),
                                  empArray.get(i).getMobile() 
                              });

    }
    table1.setModel(new DefaultTableModel(list.toArray(new Object[][] {}), 
                        new String[] {"First Name", "Surname", "Phone Number"}));
}