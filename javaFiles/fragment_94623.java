List<?> list = (List<?>) session.createQuery("FROM Project p JOIN p.contentManager").list();
List<Project> result  =  new ArrayList<Project>();  
for(int i = 0; i < list.size(); i++) {
    Object[] row = (Object[]) list.get(i);
    Project p = (Project) row[0];
    User s = (User) row[1];
    p.setContentManager(s);
    result.add(p);
}