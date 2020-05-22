import javax.swing.JOptionPane;
import java.util.ArrayList;
public class ss {
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Welcome to woodrow's program.\n" +
            "Here, you create a 2d array as big as you want..  2D array demo.");

        ArrayList<String> names = new ArrayList<>();
            while(true) {
                String nameInput = JOptionPane.showInputDialog("Enter names here:  Hit cancel when done.");
                if(nameInput == null || nameInput.equals(""))
                    break;
                names.add(nameInput);
            }
        String[][] pplInfo = new String[names.size()][];

        for(int i = 0, accumulator = 0; i < names.size(); i++) {
            ArrayList<String> pets = new ArrayList<>();
            int innerAccumulator = -1;
                    String petInput = "";
                    do{
                        petInput = JOptionPane.showInputDialog("Enter the names of " + names.get(accumulator) + 
                                "'s pets here:  (hit cancel when done)");
                        innerAccumulator++;
                        if(petInput != null || petInput.equals("")) { 
                            pets.add(petInput); 
                        }
                    }while(petInput != null && !petInput.equals(""));

                    accumulator++;

            pplInfo[i] = new String[innerAccumulator];
            //the row of person i, is going to have innerAccumulator columns listing their pets.
            //now add the pets to the appropriate row
            for(int ii = 0; ii < innerAccumulator; ii++)
                pplInfo[i][ii] = pets.get(ii);
        }
        //now to display the data you have entered in the ragged array.
        //ragged means that the number of columns differs for each row.
        for(int i = 0; i < pplInfo.length; i++) {//pplInfo.length returns number of rows
            System.out.println(names.get(i) + "'s pet list:");
            for(int ii = 0; ii < pplInfo[i].length; ii++) //pplInfo[rowIndex].length returns  # columns in respective row
                System.out.println((ii+1) + ". " + pplInfo[i][ii]);
            System.out.println("======================");
        }
        System.exit(0);
    }
}