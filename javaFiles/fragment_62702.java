char[] first  = s1.toCharArray();
char[] second = s2.toCharArray();

int length = s1.length;
int pos = 0;
boolean equal = true;

for(int i = 0; i < length && equal; i++) {
        if (first[i] == second[i]) {
            pos++;    
        } else {
            equal == false;    
        }
}
System.out.println("equal=" + equal + ", position of non-equal=" + pos);