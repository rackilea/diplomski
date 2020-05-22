import java.util.Scanner;
public class analyzeScores {
    public static void count(int[] list) {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < list.length;i++) {
            if(list[i] != 0){
                list[i] = input.nextInt();
            }else{
                break;
            }
        }
    }


    public static void sorts(int[] lists, int average) {
        int high = 0;
        int low = 0;
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] >= average) {
                high +=1;
            }
            else {
                low += 1;
            }
        }
        System.out.println("The number of higher then average scores    is " + high);
        System.out.println("The number of lower then average scores is " + low);
    }
    public static void main(String[] args) {
        int[] list = new int[10];
        System.out.println("Enter the scores: ");
        count(list);
        int total = 0;
        for (int i = 0; i < list.length;i++) {
            total += list[i];
        }
        total = total / list.length;
        sorts(list, total);
    }
}