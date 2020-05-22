package treecalc;

import javax.swing.JOptionPane;

public class TreeCalc {

    static int totalSeeds = 0;
    static int totalTrees = 0;
    static int minSeeds = 0;
    static int index = 0;

    public static void main(String[] args) {

        String[] treeTypes = new String[]{"Fir", "Pine", "Spruce"};
        int[] desiredYield = new int[treeTypes.length];
        double[] decayRate = new double[]{0.07, 0.12, 0.08};
        desiredYield = getYield(decayRate, desiredYield, treeTypes);
        getCalculate(decayRate, desiredYield, treeTypes);
        printMessage(decayRate, desiredYield, treeTypes);

    }

//Asks user to input # of trees for each tree type
    public static int[] getYield(double[] decayRate, int[] desiredYield, String[] treeTypes) {
        int index = 0;
        for (int i = 0; i < treeTypes.length; i++) {
            try {
                desiredYield[index] = Integer.parseInt(JOptionPane.showInputDialog("Please enter your desired yield for: " + treeTypes[i]));
            } catch (NumberFormatException e) {
                desiredYield[index] = 0;
                JOptionPane.showMessageDialog(null, "Error: Please enter your desired yield for " + treeTypes[i]);
            }
            if (desiredYield[index] <= 0) {
                JOptionPane.showMessageDialog(null, "Error: Please enter your desired yield for " + treeTypes[i]);
            } else {
                index++;
            }
        }

        return desiredYield;
    }

    //Calculates totals and minimums
    public static int[] getCalculate(double[] decayRate, int[] desiredYield, String[] treeTypes) {

        for (int i = 0; i < treeTypes.length; i++) {
            minSeeds += (desiredYield[index] * (decayRate[index] * 7)) + desiredYield[index];
            totalSeeds += minSeeds;
            totalTrees += desiredYield[index];

        }
        return desiredYield;
    }

    public static void printMessage(double[] decayRate, int[] desiredYield, String[] treeTypes) {
        getCalculate(decayRate, desiredYield, treeTypes);

        String treeReport = "Tree Type | Minimum Seeds | Total Seeds | Total Trees ";
        for (int i = 0; i < treeTypes.length; i++) {
            treeReport += "\n" + treeTypes[i] + " " + minSeeds + " " + totalSeeds + " " + totalTrees;
        }
        JOptionPane.showMessageDialog(null, treeReport);
    }
}