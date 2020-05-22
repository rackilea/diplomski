StringBuilder sb=new StringBuilder(100);
for {
sb.append(resultSet.getObject(i).toString());
sb.append(",");
}
println(sb.toString())