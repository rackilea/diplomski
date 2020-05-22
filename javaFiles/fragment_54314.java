import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayTest {

    public static void main(String[] args) {

        Equipment equ1 = new Equipment();
        Equipment equ2 = new Equipment();
        Equipment equ3 = new Equipment();

        //Equipment Set 1 from User Input
        System.out.println("Enter Equipment Set 1 Name: ");
        Scanner input = new Scanner(System.in);
        String equName1 = input.nextLine();
        equ1.setEquName(equName1);

        System.out.println("Enter Equipment Set 1 Gain: ");
        Double equGain1 = input.nextDouble();
        equ1.setEquGain(equGain1);

        System.out.println("Enter Equipment Set 1 Cost: ");
        Double equCost1 = input.nextDouble();
        equ1.setEquLoss(equCost1);

        double roi1 = (equGain1 - equCost1) / equCost1;
        equ1.setRoi(roi1); //Place ROI at index 3

        //Equipment Set 2 from User Input
        System.out.println("Enter Equipment Set 2 Name: ");
        String equName2 = input.nextLine();
        equ2.setEquName(equName2);

        System.out.println("Enter Equipment Set 2 Gain: ");
        Double equGain2 = input.nextDouble();
        equ2.setEquGain(equGain2);

        System.out.println("Enter Equipment Set 2 Cost: ");
        Double equCost2 = input.nextDouble();
        equ2.setEquLoss(equCost2);

        double roi2 = (equGain2 - equCost2) / equCost2;
        equ2.setRoi(roi2);

        //Equipment Set 3 from User Input
        System.out.println("Enter Equipment Set 3 Name: ");
        String equName3 = input.nextLine();
        equ3.setEquName(equName3);

        System.out.println("Enter Equipment Set 3 Gain: ");
        Double equGain3 = input.nextDouble();
        equ3.setEquGain(equGain3);

        System.out.println("Enter Equipment Set 3 Cost: ");
        Double equCost3 = input.nextDouble();
        equ3.setEquLoss(equCost3);

        double roi3 = (equGain3 - equCost3) / equCost3;
        equ3.setRoi(roi3);

        List<Equipment> equipment = new ArrayList<>();
        equipment.add(equ1); //Add each list to the array list
        equipment.add(equ2);
        equipment.add(equ3);

        equipment.sort(new Sort());
        System.out.println(equipment);
    }
}