List<String> valuesList = new ArrayList<String>();
valuesList.Add("value2");
valuesList.Add("value3");

sc.cassandraTable("test", "cf")
    .where("column1 = ?", "value1")
    .where("column2 IN ?", valuesList)
    .keyBy(new Function<MyCFClass, String>() {
                public String call(MyCFClass _myCF) throws Exception {
                    return _myCF.getId();
                }
            });