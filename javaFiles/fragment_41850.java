String s = "abc n def n ghi n";
int count = 0;
for( int i=0; i < s.length(); i++ ) {
    if( s.charAt(i) == 'n' ) {
        count++;
    } 
}   
s=s.replaceAll("n", "normal");

System.out.println(s);