String line;
while(stringTokenizer.hasMoreTokens()){

 line=stringTokenizer.nextToken();

   if(!exists && line.contains("/*")){
        exists = true;
   }
   if(exists && line.contains("*/")){
        x++;
        exists = false;
 }    
}