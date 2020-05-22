System.out.println("---START----");
if(st.nextToken() == '\'') {
   System.out.println(start(st.sval));
} else {
   // Handle error
   System.err.println("Expected 'string' after start");
}