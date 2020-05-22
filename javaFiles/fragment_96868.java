public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] number = new int[5];
    double sum = 0;
    int num=0,i;
    for(i=0;i<5&&num!=-99;i++){
        num = scan.nextInt();
        number[i] = num;
    }
    for(int k=0;k<i;k++){
        System.out.println(number[k]);
        sum+=number[k];
    }
    System.out.println(sum/(i+1));      
}