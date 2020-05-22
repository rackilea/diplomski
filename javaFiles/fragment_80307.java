import java.util.Scanner;

class apples{

    public static void main(String args[]){

        Scanner alex = new Scanner(System.in);
        Double test;
        while(true) {
            test = alex.nextDouble();
            if (test == 9){
                System.out.println("eat");
            }else{
                System.out.println("do not eat");
            }
        }
    }
}