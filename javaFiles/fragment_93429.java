public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int i=0; i<=T; i++){
        if(!sc.hasNext()) break;
        String S = sc.next();

        for(int j=0; j<S.length(); j++){
            if(j%2==0){
                System.out.print(S.charAt(j));
            }
        }

        System.out.print(" ");

        for(int r=0; r<S.length(); r++){
            if(r%2!=0){
                System.out.print(S.charAt(r));
            }
        }
        System.out.println("");

    }
}