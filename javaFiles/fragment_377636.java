public static void main(String[] args){
    Random Rnum = new Random();
    int[] ar1 = new int[100];
    int counter=0;
    double total=0;
    for(int i = 0; i < 5; i++) {
        ar1[i] = Rnum.nextInt(100);
           System.out.print(ar1[i] + "  ");

        if(ar1[i] > 70)
        {    
            total+=ar1[i];
            counter++;
            System.out.print(ar1[i] + "  ");
        }
    }
    if(counter>0)
    {
        double average=total/counter;
        System.out.println("average="+average);
    }

}