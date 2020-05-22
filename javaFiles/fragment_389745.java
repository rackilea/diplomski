Public void getItem (){
try {
       while(rs.next){
         this.jcombobox1.addItem (rs.getString (1));
         Bclassobj.Bclassjcombobox.addItem (rs.getString (1));
     }

    }
   }