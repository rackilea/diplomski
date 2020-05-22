package choosertest;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ChooserTest extends JFrame {

    File[] selected;
    JFileChooser chooser;

    public ChooserTest() {
        chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        testOpen();
    }

    public static void main(String[] args) {
        new ChooserTest();
    }

    private void testOpen() {

        chooser.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("SelectedFilesChangedProperty")) {
                    if (selected == null) {
                        selected = (File[]) evt.getNewValue();
                    } else {
                        File[] newSelection = (File[]) evt.getNewValue();

                        if (newSelection == null) {
                            selected = null;
                        }
                        // check back and forth to preserve the order of files
                        // as the user added them
                        else {
                            List<File> orderedSel = new LinkedList<>();

                            // add files that are still selected
                            for (File f : selected) {
                                for (File f2 : newSelection) {
                                    if (f.equals(f2)) {
                                        orderedSel.add(f);
                                        break;
                                    }
                                }
                            }

                            Arrays.sort(selected);
                            // add newly selected files
                            for (File f : newSelection) {
                                if (Arrays.binarySearch(selected, f) < 0) {
                                    orderedSel.add(f);
                                }
                            }

                            selected = orderedSel.toArray(
                                    new File[orderedSel.size()]);
                        }
                    }
                    System.out.println(Arrays.toString(selected)); //debug
                }
            }
        });

        // copy previous array of selected files
        File[] prevSelected = null;
        if (selected != null) {
            prevSelected = new File[selected.length];
            System.arraycopy( selected, 0, prevSelected, 0, selected.length );
        }

        int choice = chooser.showOpenDialog(this);

        // if the user did not cancel the selection
        if (choice == JFileChooser.APPROVE_OPTION) {
            System.out.println("FINAL selection: " + Arrays.toString(selected)); //debug
        } else {
            // restore the previous selection
            selected = prevSelected;
            System.out.println("PREVIOUS selection: " + Arrays.toString(selected)); //debug
        }
    }

}