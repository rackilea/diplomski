Query<Department> query = Ebean.find(Department.class)
        .where().eq("name", "DevOps").query();
Department department = query.findUnique();
String queryString = query.getGeneratedSql();
System.out.println(queryString);
System.out.println(department); // uses this.employees in #toString() - so will lazily fetch child entities