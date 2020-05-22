try{

     for (int i = 0; i < itemCount; i++) {
         combo.removeItemAt(0);
     }


     rs = stmt.executeQuery("select * from menu_cat");

     int i = 0;
     String[] categories = new String[99];

     while(rs.next()){

         categories[i] = rs.getString("menu_cat");            
         i++;            
     }

     i = 0;

     while(!categories[i].equals("")){

          combo.addItem(categories[i]);
         i++;

     }

}catch (Exception e){

     System.out.println("Unimportant error: " + e);
}