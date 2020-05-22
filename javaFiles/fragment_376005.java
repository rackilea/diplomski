import javax.swing.*;

public class WorkerDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane optionPane = new JOptionPane("do u want to stop  posting?",
                                                     JOptionPane.QUESTION_MESSAGE,
                                                     JOptionPane.YES_NO_OPTION);


            JDialog dialog = optionPane.createDialog("Select Yes or No");
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

            Timer timer = new Timer(5000, e -> dialog.setVisible(false));
            timer.setRepeats(false);
            timer.start();

            dialog.setVisible(true);

            if (optionPane.getValue() instanceof Integer) {
                int option = (Integer) optionPane.getValue();

                if (option == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked");
                }
                else if (option == JOptionPane.YES_OPTION) {
                    System.out.println("Yes button clicked");
                }
            }
            else {
                System.out.println("dialog was closed by timer");
            }

            System.out.println("Outside code.");
        });
    }
}