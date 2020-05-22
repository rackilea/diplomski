public static void reverse(String n) {
        for (int i = 0; i < n.length(); i++) {
            n = n.substring(1, n.length() - i)
                    + n.substring(0, 1)
                    + n.substring(n.length() - i, n.length());
        }
        System.out.println(n); <---- print out the reverse result on the console
                                     from the reverse function 
    }