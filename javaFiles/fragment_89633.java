Statement stmt = conn.createStatement();
Statement stmt1 = conn.createStatement();
...
ResultSet res = stmt.executeQuery(Query);

...

while(res.next()){

     S_Code = res.getString("S_Code");
     Query1 = "SELECT * From Subjects WHERE Prerequisite = '"+S_Code+"'";
     res1 = stmt1.executeQuery(Query1); // use a separate statement

    while(res1.next()){

        DLM.addElement(res.getString("S_Code"));
    }

}