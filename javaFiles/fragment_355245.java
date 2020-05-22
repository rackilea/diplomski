Public List<myPojoClass> getDataByCriterion( List<Criterion> restrictionList, HashMap<String,String> aliases) {
Session s = HibernateUtil.currentSession(); 
Criteria c = s.createCriteria(myPojo.class); 
for (Criterion crit : restrictionList){     
    c.add(crit); 
}
for (Entry<String, String> entry : aliases.entrySet()){
    c.createAlias(entry.getKey(), entry.getValue());
}

List<myPojoClass> response = c.list(); 
return response;
}