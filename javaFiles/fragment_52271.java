import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    private Scanner scan = new Scanner(System.in);
    private List<LayoutOfScientist> scientistsNames = new ArrayList<LayoutOfScientist>();
    private String name, field, idea;
    private boolean continueLoop = true;
    private int countTo3 = 0;

    private void run() {
        while(countTo3<3&&continueLoop) {
            if(countTo3>0) {
                System.out.println("Would you like to add another scientist? (Y/N)");
            }

            if(countTo3 == 0 || scan.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Please enter the scientist's name:");
                name = scan.nextLine();
                System.out.println("Please enter the scientist's field:");
                field = scan.nextLine();
                System.out.println("Please enter the scientist's idea:");
                idea = scan.nextLine();
                scientistsNames.add(new LayoutOfScientist(name, field, idea));
            } else {
                continueLoop = false;
            }
            countTo3++;
        }

        scientistsNames.sort(Comparator.comparing(LayoutOfScientist::getScientistName));
        for(LayoutOfScientist lOS : scientistsNames) {
            System.out.println(lOS.getScientistName() + ", " + lOS.getScientistField() + ", " + lOS.getScientistIdea());
        }
    }

    private class LayoutOfScientist {
        private String scientistName, scientistField, scientistIdea;

        private LayoutOfScientist(String scientistName, String scientistField, String scientistIdea) {
            this.scientistName = scientistName;
            this.scientistField = scientistField;
            this.scientistIdea = scientistIdea;
        }

        public String getScientistName() {
            return scientistName;
        }

        public String getScientistField() {
            return scientistField;
        }

        public String getScientistIdea() {
            return scientistIdea;
        }
    }

    public static void main(String[] args) {
        new Test().run();
    }
}