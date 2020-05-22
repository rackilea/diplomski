st = conn.createStatement();
rs = st.executeQuery("SELECT * from geopools");           
while(rs.next()){
   System.out.println(rs.getInt("id"));
   ResultSet rs2 = st.executeQuery("SELECT * from Geofields where id_pool='"+rs.getInt("id")+"'");
   while (rs2.next()) {
         System.out.println(rs2.getString("name")+"//");
   }
}