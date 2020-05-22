StringBuilder sbQry = new StringBuilder();
List<String> params = new ArrayList<>();
sbQry.append("select * from tableName");
if(!myCollection.isEmpty()){
    sbQry.append(" where ");
    int size = myCollection.size;
    List<String> terms = new ArrayList<>();
    for (int i = 0; i < size; i++) {
        final String module = myCollection.get(i);
        terms.add("column = ? or column like ?");
        params.add(module);
        params.add("J_" + module.replaceAll("-", "%"));
    }
    sbQry.append(String.join(" or ", terms));
}

Query q = sess.createQuery(sbQry);
int size = params.size();
for (int i = 0; i < size; i++) {
    q.setString(i, params[i]);
}