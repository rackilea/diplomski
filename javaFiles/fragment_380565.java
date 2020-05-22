public Node readFile(BufferedReader reader){
     String word = reader.readLine();         
     if(word!=null){
         return new Node(word, readFile(reader), readFile(reader));            
     }else{
         return new Node() ;  // empty node or null?
     }      
 }