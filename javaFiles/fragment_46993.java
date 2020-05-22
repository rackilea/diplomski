import java.util.Scanner;     
public static void main(String[] args) {
            int count = 0;
            float sum = 0;
            float grade = 0;
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter number of grades: ");
            count = scan.nextInt();

            for (int i = 0; i < count; i++) {
                System.out.print("Enter grade no " + (i + 1) + " : ");
                grade = scan.nextFloat();
                sum += grade;
            }
            System.out.println("Sum = " + sum);
            System.out.println("Average = " + sum / (float) count);
        }