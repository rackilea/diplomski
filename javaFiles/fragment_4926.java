new Model<String>() {
   @Override
   public String getObject() {
     if( columnName.equals( selectedColumn ) { //or something along these lines, to check if the current column is the selected one
        return "background-color:#80b6ed;";
     }
     return "background-color:white;";
   }
}