public void updateBalance(float newBalance,List<String> ids) {
    String hql = "update UserHistory set balance= :newBalance where id in (:ids)";
    Query query = session.createQuery(hql);
    query.setFloat("newBalance",newBalance);
    query.setParameterList("ids",ids);
    int rowCount = query.executeUpdate();
    System.out.println("Rows affected: " + rowCount);
}

updateBalance(0,Arrays.asList("5","7","8"));
updateBalance(85.9,Arrays.asList("10"));