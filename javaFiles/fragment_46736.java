import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeListener;

class ZipQuery {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                ZipNumberModel znm = new ZipNumberModel();
                JSpinner zip = new JSpinner(znm);

                JOptionPane.showMessageDialog(null, zip, "Enter Zipcode", JOptionPane.QUESTION_MESSAGE);
                System.out.println("User chose " + znm.getValue());
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}

class ZipNumberModel extends SpinnerNumberModel {

    private ArrayList<Integer> zipCodes;
    private int index = 0;

    ZipNumberModel() {
        zipCodes = new ArrayList<Integer>();
        int zip = 10000;
        for (int jj = 1; jj < 4; jj++) {
            for (int ii = jj * zip; ii < jj * zip + 10; ii++) {
                zipCodes.add(new Integer(ii));
            }
        }
    }

    @Override
    public Object getValue() {
        return zipCodes.get(index);
    }

    @Override
    public Object getNextValue() {
        if (index < zipCodes.size()-1) {
            index++;
        } else {
            index = 0;
        }
        return zipCodes.get(index);
    }

    @Override
    public Object getPreviousValue() {
        if (index > 0) {
            index--;
        } else {
            index = zipCodes.size()-1;
        }
        return zipCodes.get(index);
    }
}