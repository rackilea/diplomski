try{
       rs.next();
       System.out.println(rs.getString("5"));

   }catch(Exception ex){
       System.out.println(ex.getMessage("5"));
   }