public static void main(String[] args) {         
   int array[] = {19, 4, 15, 7, 11, 9, 13, 5, 45, 56, 1, 67, 90, 98, 32, 36, 33, 25, 99, 95, 97, 98, 92, 94, 93, 105}; 
   histogram(array);
}
public static void histogram(int[] input) {
    for(int i = 1; i<101; i = i+10){
        System.out.print(i + "-" + (i+9) + "\t| ");
        for(int j = 0; j< input.length; j++){
            if(input[j] >= i && input[j] < i+10)
            System.out.print("*");
        }
        System.out.println();
    }
}