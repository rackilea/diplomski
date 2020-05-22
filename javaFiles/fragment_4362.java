@Override
 public String toString()
 {
     StringBuilder builder = new StringBuilder();
      for(int i = 0; i < personArray.length; i++)
     {
         builder.append(" All people currently residing on the stack: " +personArray[i]);
     }


     return builder.toString();
 }