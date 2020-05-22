ResultSet rs = st.executeQuery("SELECT * FROM A");
ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();

String insert_string = "INSERT INTO B(" ;
for (int i = 1; i < columnCount + 1; i++) {
     String column = rsmd.getColumnName(i);
     insert_string += column + ", " ;
     }
insert_string += " )"; // Column part of INSERT INTO B should be well formed

insert_string += " VALUES (" ;

int i=0;
while(i < columnCount - 1){
    i++;
    insert_string += "'"+ rs.getString(i)+"', " ;
}

insert_string += "'" + rs.getString(columnCount) + ")" ; // VALUES part should be ok by now