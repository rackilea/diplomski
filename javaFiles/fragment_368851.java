String s1 = "xyaabbbccccdefww", s2 = "xxxxyyyyabklmopq";
String s = s1+s2;
char[] c = s.toCharArray();
java.util.Arrays.sort(c);
StringBuilder result = new StringBuilder();
for(int i = 0; i<c.length ; i++) {
    boolean isDuplicate=false;
    for(int j = i+1 ; j<c.length; j++) {
        if(c[i]==c[j]) {
            isDuplicate=true;
            break;
        }
    }
    if(!isDuplicate) {
        result.append(c[i]);
    }
}
System.out.println(result.toString());