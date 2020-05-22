<script>
    <%
        String sql = "create table if not exists materias ("
                + "codigo decimal (8),"
                + "nombre varchar (40),"
                + "turno text [],"
                + "ref_profesor varchar (10)"
                + ");";
        Statement myStmt = con.getConexion().createStatement();
        myStmt.executeUpdate(sql);
%>
window.location="button.jsp";