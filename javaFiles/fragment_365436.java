public String reverse(String s){
         String r = ""; //this is the ouput , initialized to " "
         for(int i=0; i<s.length(); i++){  
           r = s.charAt(i) + r; //add to String r , the caracter of index i 
        }
          return r;
        }