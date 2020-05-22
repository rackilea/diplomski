ResultSet rs = con.createStatement().executeQuery("SELECT * FROM table");
        ResultSetMetaData rsMetaData = rs.getMetaData();
        Map<String, List<Object>> resultMap = new LinkedHashMap<>();
        while (rs.next()) {
            for(int i=1;i<=rsMetaData.getColumnCount();i++) {
                String strColumnName = rsMetaData.getColumnName(i);
                Object columnValue = rs.getObject(i);
                if(resultMap.containsKey(strColumnName)){
                    resultMap.get(strColumnName).add(columnValue);
                }else{
                    List<Object> resultList = new ArrayList<>();
                    resultList.add(columnValue);
                    resultMap.put(strColumnName,resultList);
                }
            }
        }
        // Iterate Data Column Wise
        for(Iterator<Map.Entry<String, List<Object>>> iterator = resultMap.entrySet().iterator();iterator.hasNext();){
            Map.Entry<String, List<Object>> entry = iterator.next();
            System.out.println("Column Name: "+entry.getKey());
            System.out.println("Column Values: "+entry.getValue());
        }