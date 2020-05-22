class ReturnParameterComparator implements Comparator<JSONObject> {
   private List<ReturnParameter> params; //set via constructor

   public int compare( JSONObject left, JSONObject right) {
     int result = 0;
     for( ReturnParameter p : params ) {
       //how exactly you get those values depends on the actual structure of your data and parameters
       String leftValueStr = left.get( p ); 
       String rightValueStr = right.get( p ); 

       switch( p.datatype ) {
         case "String": 
           result = String.compare( leftValueStr, rightValueStr );
           break;
         case "int": 
           //convert and then compare - I'll leave the rest for you 
       }

       //invert the result if the order is descending
       if( "desc".equals(p.order ) {
         result += -1;
       }

       //the values are not equal so return the order, otherwise continue with the next parameter
       if( result != 0 ) {
         return result;
       }
     }

     //at this point all values are to be considered equal, otherwise we'd have returned already (from the loop body)
     return 0;
   }
}