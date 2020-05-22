TableB tableb = new TableB();
    tableb.setDate(new Date());
    tableb.setName("tableb2");
    em.persist(tableb);  // fills tableb id
    System.out.println(tableb); 
    TableA tableA = new TableA();
    tableA.setfId((int) new Date().getTime());
    tableA.setField1("field1");
    tableA.setField2("field2");
    tableA.setItem("item2");
    tableA.setRelease("1");
    tableA.setTableB(tableb);
    ArrayList<TableA> rows = new ArrayList<TableA>();
    rows.add(tableA);
    tableb.setRows(rows);
    em.merge(tableb);  // inserts tablea objects, you could also just persist tableA items