public static void main(String []args){
    Scanner x = new Scanner(System.in);
    int t = x.nextInt();
    String[] p = new String[t];

    for (int j = 0; j < t; j++) {
        p[j] = x.nextLine();
    }

    for (j=0; j<p.length(); j++) {
        ...
    }
}