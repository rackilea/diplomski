public class SumOdd5 {
    static int[] array = new int[15];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Enter numbers");
        for(int i = 0; i<array.length; i++){
            array[i]=sc.nextInt();
        }
        int sum = sumOddDiv5();
        System.out.println("Sum of Number : "+sum);
    }

    public static int sumOddDiv5(){
        int sum=0;
        for(int i = 0; i<array.length; i++){

            if(array[i] % 2 !=0 && array[i] % 5 ==0){
                  sum +=array[i]; 
            }
        }
        return sum;
    }
}