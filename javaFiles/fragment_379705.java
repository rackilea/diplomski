public String[] getcDataCondicion(){
    String query = "";

    String[] cDataCondicion= new String[100];
        query = "select C&#95;Condicion&#95;Beca from Bca&#95;Condicion&#95;Beca";
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            int i=0;
            while (rs.next()){
                cDataCondicion[i] = rs.getString("C&#95;Condicion&#95;Beca");
                 i++;
               }
        }
        catch(SQLException e){
        System.out.println("Error al obtener los datos: "+e.getMessage());

        }

    return cDataCondicion;
}

<%  

  YourClass c= new YourClass();
String[] result=c.getcDataCondicion();
%>

<Select>
<%
  for(int i=0;i<result.length;i++){
%>
 <Option>result[i]</ Option>
<% } %>
</select>