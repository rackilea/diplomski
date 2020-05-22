if (dataFrame.take(1).length > 0) {
    Iterator<String> itt = dataFrame.toJSON().toJavaRDD().collect().iterator();
    while(itt.hasNext()) { 
        String field = itt.next();
        JSONObject jsonResponse = new JSONObject(field);
        System.out.println("jsonString:" + jsonResponse );

}