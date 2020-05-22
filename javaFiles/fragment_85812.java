class Numbers {
    public static void main (String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify number.");
            return;
        }
        int iterationCount = Integer.parseInt(args[0]);
        for ( int i = 0; i < iterationCount; i++) {
            int a = i;
            System.out.print(a);
            int b = (a*a);  
            int c = (a*a*a);
            System.out.print(b);
            System.out.print(c);
        }       
    }
}