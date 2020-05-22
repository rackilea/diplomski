List<Object> parameters = new ArrayList<>();
/*
    Parameter to evaluate:
    String[] Brand, String[] Flavour,float Price,float Size,String Type
*/
StringBuilder query = new StringBuilder("SELECT * FROM products WHERE 1=1");
if (Brand != null) {
    query.append(" AND brand in (");
    for (int i = 0; i < Brand.length; i++) {
        query.append('?');
        if (i < Brand.length - 1) {
            query.append(',');
        }
        parameters.add(Brand[i]);
    }
    query.append(")");
}
if (Flavour != null) {
    query.append(" AND Flavour in (");
    for (int i = 0; i < Flavour .length; i++) {
        query.append('?');
        if (i < Flavour.length - 1) {
            query.append(',');
        }
        parameters.add(Flavour[i]);
    }
    query.append(")");
}
if (Price != 0) {
    query.append(" AND Price < ?");
    parameters.add(Price);
}
if (Size != 0) {
    query.append(" AND Size < ?");
    parameters.add(Size);
}
if (Type != null) {
    query.append(" AND Type = ?");
    parameters.add(Type);
}
//prepare the statement
stmt = DataBaseConnection.DBConn.getConnection().prepareStatement(query);
//append the parameters
int i = 1;
for (Object parameter : parameters) {
    stmt.setObject(i++, parameter);
}
//execute the dynamic query
rs = stmt.executeQuery();
if (rs != null) {
    //rest of your code
}