package tarea3_1;

import javax.swing.*;

public class Tarea3_1 {

public static void main(String[] args) {

    int Num, f;
    String[] NumArray;

    Num = Integer.parseInt(JOptionPane.showInputDialog(null,
            "Increse numero des etudiants: "));
    NumArray = new String[Num];

    for (f = 0; f < NumArray.length; f++) {

        NumArray[f] = JOptionPane.showInputDialog("Nombre " + f + ": ");
    }

    for (int R = 0; R < NumArray.length; R++) {
        names += NumArray[R] +"\n";

    }
    JOptionPane.showMessageDialog(null, names );
}

}