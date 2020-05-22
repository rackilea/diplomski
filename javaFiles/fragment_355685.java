package gui.examples;

import javax.swing.JOptionPane;

public class LogicClass {

    public void info(String message, String title) {
        JOptionPane.showMessageDialog(null, message, "PromptBox: " + title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void enterButton() {
        LogicClass obj = new LogicClass();
        if (MaisamCustom.txt1.getText().equals(MaisamCustom.txt2.getText())) {
            obj.info("Both Fields Match !!!", "Note !!");
        } else {
            obj.info("Both Fields Do Not Match !!!", "Note !!");
        }
    }

}