private static List<Map<String, Object>> resultToHashmap(List<Object[]> resultList, String[] fieldNames ){

        List<Map<String, Object>> resultMap  = new ArrayList();
        for (Object[] result : resultList){
            HashMap<String,Object> row = new HashMap<String, Object>(result.length);
            for (int i=0;i<result.length;i++){
                row.put(fieldNames[i],result[i]);
            }
            resultMap.add(row);
        }
        return resultMap;
    }