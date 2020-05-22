import java.util.Scanner;

class Mode {
    public static void main(String[] args) {
        computeMode();
    }

    public static void computeMode(){
        int nums[]=new int[10];
        Scanner scanner = new Scanner(System.in);

        int maxValue = -1;
        int maxCount = 0;
        int x = 0;
        //count how many times nums[i] appears in array

        System.out.println("Enter 10 numbers: ");
        for (int i = 0; i < 10; i++) {

            try { //try catch exception to catch decimal inputs as well as more /less than 10 integers
                x = scanner.nextInt();
                nums[i]=x;
            } 
            catch (Exception e) {
                System.out.println("Invalid input! Please reenter 10 integer values.");
                i =i -1;
                scanner.nextLine();

                continue;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxValue = nums[i];
                maxCount = count;

            }

        }
    System.out.println("The mode is: " + maxValue);
    }


}