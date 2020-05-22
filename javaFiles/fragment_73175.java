Stringbuilder sql = new StringBuilder("SELECT * FROM calcul");
if (EndDate != null && StartDate != null){
    sql.append(" WHERE dateper<='"+EndDate+"' AND dateper>='"+StartDate+"'");
else if (EndDate == null && StartDate != null){
    sql.append(" WHERE dateper>='"+StartDate+"'");
}else if (EndDate != null && StartDate == null){
    sql.append(" WHERE dateper<='"+EndDate+"'");
}
ResultSet rsDate=stmt.executeQuery(sql);