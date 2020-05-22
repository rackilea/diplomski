public String getEach()
   {
     StringBuffer sb = new StringBuffer();

     for (int i : each) {
       sb.append(i).append(",");
     }

     return sb.toString();
   }