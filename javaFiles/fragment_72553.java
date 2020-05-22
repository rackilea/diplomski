public static void main (String[] args) {
    Scanner scn= new Scanner(System.in);
    int T ;
    T=scn.nextInt();

    // scn.nextLine();  // for enter.
    // here after entering int value, 
    // you must be pressing enter,
    // that 'enter' is getting stored in s1,
    // and then when you give first string it is getting stored in s2 
    // and that is why your program is terminating.

    while(T!=0){
        String s1 = scn.nextLine(); // after i give input for the first string ,program terminates!
        String s2 = scn.nextLine(); // program terminates before asking for s2 input
        System.out.println(isMetaString(s1,s2));
        T--;
    }
}