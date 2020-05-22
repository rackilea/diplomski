RowFilter<Object,Object> startsWithAFilter = new RowFilter<Object,Object>() {
   public boolean include(Entry<? extends Object, ? extends Object> entry) {
     for (int i = entry.getValueCount() - 1; i >= 0; i--){            
       if(entry.getStringValue(i).startsWith("a")) {
         // The value starts with "a", include it
         return true;
       }
     }
     // None of the columns start with "a"; return false so that this
     // entry is not shown
     return false;
   }
 };