public static String hexToASCII(String hex){        
 if(hex.length()%2 != 0){
    System.err.println("requires EVEN number of chars");
    return null;
 }
 StringBuilder sb = new StringBuilder();                
 for( int i=0; i < hex.length()-1; i+=2 ){
     String output = hex.substring(i, (i + 2));
     int decimal = Integer.parseInt(output, 16);
   sb.append((char)decimal); 
 }            
 return sb.toString();
}