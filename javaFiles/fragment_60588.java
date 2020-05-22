import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

public class MVC2 {

    private static void createAndShowGui() {
        MvcModel model = new MvcModel();
        MvcView view = new MvcView();
        MvcController controller = new MvcController(model, view);
        controller.init();

        JFrame frame = new JFrame("MVC2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(view.getMainDisplay());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}