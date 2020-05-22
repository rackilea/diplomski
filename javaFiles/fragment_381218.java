StringBuilder strbul  = new StringBuilder();
     Iterator<Integer> iter = list.iterator();
     while(iter.hasNext())
     {
         strbul.append(iter.next());
        if(iter.hasNext()){
         strbul.append(",");
        }
     }
 strbul.toString();