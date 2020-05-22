public static void printDots(int val, int condition) { 
    if(val < condition - 1) { 
        System.out.print("."); 
        printDots(val + 1, condition);
    } 
}

public static void Esc(int n1, int n2, boolean reverse) {
    int val = (n2 + 1 - n1);      // this gives 1 for n, 2 for n-1, 3 for n-2 etc.
    if (n1 > 1 && !reverse) {     // print from 1 to n 
        printDots(0, val);        // print dots
        System.out.println(val);
        Esc(n1 - 1, n2, reverse);
    } else if (n1 <= n2) {        // print from n to 1
        reverse = true;
        printDots(0, val);        // print dots
        System.out.println(val);
        Esc(n1 + 1, n2, reverse);
    }
}

public static void main(String args[]) {
    Esc(5, 5, false);
}