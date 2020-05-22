public static void main(String[] args) {
    String s=" 1 3 4 5 22 3 2";
    int[] counts=count(s);
    for(int i=0;i<10;i++) 
        if(counts[i]==1) {
            System.out.println(i + " appears " + counts[i] +" time");
        }
        else if(counts[i]!=1 && counts[i]!=0) {
            System.out.println(i + " appears " + counts[i] +" times");
        }
}

public static int[] count(String s) {
    int count[] =  new int[10];

    for(int i=0;i<s.length();i++) 
        if(Character.isDigit(s.charAt(i)))
            count[(int)s.charAt(i) - (int)'0']++;

    return count;
}