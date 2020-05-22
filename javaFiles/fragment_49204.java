@NamedNativeQueries({
     @NamedNativeQuery(
             name = "MyQuery",
             query = "SELECT * FROM my_table WHERE c1 IN (:v1) " + 
                         "AND c2 IN (:v2) " +
                         "AND concat(c1, "~", c2) IN (:concatV1V2)",
             resultSetMapping = "MyMapper")
}) 

return (List<MyDto>) getNamedQuery("MyQuery")
        .setParameter("v1", new String[] {"v1_1", "v2_1"})
        .setParameter("v2", new String[] {"v1_2", "v2_2"})
        .setParameter("concatV1V2", new String[] {"v1_1~v1_2", "v2_1~v2_2"})
        .list();