SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("sqlConfig.xml"));
SqlSession sess = sqlMapper.openSession();
try {
   Map<String,String> paramObj = new HashMap<String,String>();
   paramObj.put("param1", "value");
   int result = sess.insert("insertRequestTrackingRow", paramObj);
   System.out.println("REQ_ID: " + paramObj.get("REQ_ID"));
}
finally {
   sess.close();
}