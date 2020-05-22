String s1 = "xyaabbbccccdefww", s2 = "xxxxyyyyabklmopq";
String s = s1+s2;
char[] c = s.toCharArray();
java.util.Arrays.sort(c);
char[] result = new char[c.length];
int resultIndex = 0;
for(int i = 0; i<c.length ; i++) {
    boolean isDuplicate=false;
    for(int j = i+1 ; j<c.length; j++) {
        if(c[i]==c[j]) {
            isDuplicate=true;
            break;
        }
    }
    if(!isDuplicate) {
        result[resultIndex++]=c[i];
    }
}
char[] actualResult = new char[resultIndex];
for(int i=0;i<resultIndex;i++) {
    actualResult[i] = result[i];
}
System.out.println(String.valueOf(c));
System.out.println(String.valueOf(result));
System.out.println(String.valueOf(actualResult));