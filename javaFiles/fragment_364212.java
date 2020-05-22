import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

class PetSelector {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel gui = new JPanel(new GridLayout(0,1,5,5));

                String[] speciesName = { "Dog", "Cat", "Bird"};
                final String[][] breedName = {
                    {"Basenji", "Pomeranian", "Alsation"},
                    {"Burmese", "Persian", "Siamese"},
                    {"DoDo", "Archeopteryx", "Pheonix"}
                };
                final JComboBox petSpecies = new JComboBox(speciesName);
                final JComboBox petBreed = new JComboBox();
                ItemListener speciesListener = new ItemListener() {

                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        int ii = petSpecies.getSelectedIndex();
                        ComboBoxModel cbm = new DefaultComboBoxModel(breedName[ii]);
                        petBreed.setModel(cbm);
                        petBreed.requestFocusInWindow();
                    }
                };
                petSpecies.addItemListener(speciesListener);
                gui.add(petSpecies);
                gui.add(petBreed);

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}