public static void main(String[] args) {
    int counter = 0;  
    int start = 2;
    while (counter < 50) {
        if (isPrime(start) && isPalin(start)) {
            System.out.print(start + " ");
            counter++;
            if (counter % 10 == 0) {
                System.out.println();
            }
        }
        start++;
    }
}

public static boolean isPalin(int x) {
    String s = Integer.toString(x);
    for(int i = 0; i < s.length()/2; i++) {
        if(s.charAt(i) != s.charAt(s.length()-i-1)) {
            return false;
        }
    }
    return true;
}
public static boolean isPrime(int x) {
    if (x % 2 == 0 && x != 2) {
        return false;
    }

    int sqr = (int)Math.sqrt(x);
    for (int i = 3; i <= sqr; i += 2) {
        if(x % i == 0) {
            return false;
         }
     }
     return true;
}