.forEach(g -> {
       if(g instanceof TheType){
           System.out.println(((TheType)g).getEdge());
       }
       else{
           // "interrupted"
       }
   });