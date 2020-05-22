package stackoverflow;

import javax.swing.*;
import java.awt.*;

public class IngredientJFrame {

    public static void main(String... args) {

        IngredientJFrame ingredientJFrame = new IngredientJFrame();
        ingredientJFrame.init();
    }

    public void init() {

        JFrame jFrame = new JFrame();

        //making a new panel
        //initializing the new Panel
        JPanel p_addIng = new JPanel();
        p_addIng.setLayout(new GridBagLayout());

        GridBagConstraints gbc_ing = new GridBagConstraints();

        JLabel l_addIng = new JLabel("Add Ingredient");
        gbc_ing.gridx = 0;
        gbc_ing.gridy = 0;
        p_addIng.add(l_addIng, gbc_ing);

        JTextField tf_ingName = new JTextField();
        gbc_ing.gridx = 1;
        gbc_ing.gridy = 0;
        gbc_ing.fill = GridBagConstraints.HORIZONTAL;
        p_addIng.add(tf_ingName, gbc_ing); //adding the component to the Panel

        JLabel tf_amnt = new JLabel("Choose amount");
        gbc_ing.gridx = 0;
        gbc_ing.gridy = 1;
        gbc_ing.fill = GridBagConstraints.NONE;
        p_addIng.add(tf_amnt, gbc_ing);

        JComboBox cb_measurement = new JComboBox();
        gbc_ing.gridx = 1;
        gbc_ing.gridy = 1;
        gbc_ing.fill = GridBagConstraints.HORIZONTAL;
        p_addIng.add(cb_measurement, gbc_ing);

        JButton b_addIng = new JButton("Add Ingredient");
        gbc_ing.gridx = 0;
        gbc_ing.gridy = 2;
        gbc_ing.fill = GridBagConstraints.NONE;
        p_addIng.add(b_addIng, gbc_ing);

        JButton b_removeIng = new JButton("Remove Ingredient");
        gbc_ing.gridx = 1;
        gbc_ing.gridy = 2;
        p_addIng.add(b_removeIng, gbc_ing);

        jFrame.pack();
        jFrame.add(p_addIng);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
    }
}