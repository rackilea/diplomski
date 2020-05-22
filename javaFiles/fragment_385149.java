Map<String, Object> contextMap = new HashMap<String, Object>();
    List<DB_record>db_data = new ArrayList<>();
    DB_record data1 = new DB_record();
    data1.setId("1");
    data1.setValue("soora");

    DB_record data2 = new DB_record();
    data2.setId("2");
    data2.setValue("tamil");
    db_data.add(data1);
    db_data.add(data2);
    dbDataObject.setDbDatas(db_data);
    contextMap.put("db_data",db_data);