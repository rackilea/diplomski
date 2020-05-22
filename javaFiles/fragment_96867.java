public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean cond = false;
    int i = 0;
    int[] number = new int[5];
    double sum = 0;
    do{
        int num = scan.nextInt();
        if(num!=-99){
           number[i] = num;
           i++;
        }

        if(num==-99 || i==5){
            for(int k=0; k<i; k++){
                System.out.println(number[k]);
                sum = sum + number[k];
            }
            System.out.println(sum/(i));
            cond = true;
        }

    }while(!cond);
}