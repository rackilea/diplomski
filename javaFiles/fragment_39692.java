List<Map<String,String>> rolledupEmps = new ArrayList<Map<String,String>>();
for(Emp emp : emps){
     Map<String,String> em = mapper.readValue(emp, HashMap.class);
     em.put("projectId",em.get("projects")?!=null:em.get("projects").get("projectId"),"");
     em.put("projectName",em.get("projects")?!=null:em.get("projects").get("projectName"),"");
     em.remove(""projects"");
     rolledupEmps.put(em);
}
return mapper.writeValueAsString(rolledupEmps);