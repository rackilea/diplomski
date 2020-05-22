public static void inNum() {
    List<Integer> alist= new ArrayList<Integer>();
    List<Integer> blist= new ArrayList<Integer>();

     Scanner input = new Scanner(System.in);
        for (int i=0;i<5;i++){
            int k= input.nextInt();
                alist.add(k);
        }

        System.out.println("the alist is="+alist);
        for (int j=0;j<5;j++){
            int m= input.nextInt();
                blist.add(m);
        }


}