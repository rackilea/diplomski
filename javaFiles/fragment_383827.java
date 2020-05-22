String query = "SELECT c FROM C c";
String checkValue = "";

for(int i = 0; i<queryString.size();i++){

    checkValue = queryString.get(i);

    if(i==queryString.size()-1){
        query += " WHERE '" + checkValue + "'" + " MEMBER OF c.sequence";
    }else{
        query += " WHERE '" + checkValue + "'" + " MEMBER OF c.sequence AND";
    }
}