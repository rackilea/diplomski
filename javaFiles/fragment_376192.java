import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.kaizen.icons.AddIcon;
import org.kaizen.icons.DeleteIcon01;
import org.kaizen.icons.DeleteIcon02;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultComboBoxModel model = new DefaultComboBoxModel<Car>();
                model.addElement(new Car(new AddIcon(16, 16), "Honda"));
                model.addElement(new Car(new DeleteIcon01(16, 16), "Mitsubishi"));
                model.addElement(new Car(new DeleteIcon02(16, 16), "Tyota"));

                JComboBox cb = new JComboBox(model);
                cb.setRenderer(new CarListCellRenderer());

                int result = JOptionPane.showConfirmDialog(null, cb, "Select a car model from the list below", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    Car car = (Car) cb.getSelectedItem();
                }

            }
        });
    }

    public static class CarListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            System.out.println(value);
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Car) {
                Car car = (Car) value;
                setIcon(car.getIcon());
                setText(car.getText());
            } else {
                setIcon(null);
            }
            return this;
        }

    }

    public static class Car {

        private Icon icon;
        private String text;

        public Car(Icon icon, String text) {
            this.icon = icon;
            this.text = text;
        }

        public Icon getIcon() {
            return icon;
        }

        public String getText() {
            return text;
        }

    }

}