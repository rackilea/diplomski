import java.awt.event.*;
import java.io.File;
import java.util.List;
import javax.swing.*;
import javax.xml.bind.*;

public class TestComboJaxB {

    private static final String FILE_PATH = "src/combobox/genericname.xml";

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                File file = new File(FILE_PATH);
                ComboBoxModel model = new DefaultComboBoxModel(getNames(file).toArray());
                final JComboBox cbox = new JComboBox(model);
                cbox.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        Name name = (Name)cbox.getSelectedItem();
                        System.out.println(name.getLink());
                    }
                });
                JOptionPane.showMessageDialog(null, cbox);
            }
        });
    }

    private static List<Name> getNames(File file) {
        List<Name> names = null;
        try {
            JAXBContext context = JAXBContext.newInstance(GenericName.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            GenericName genericName = (GenericName)unmarshaller
                    .unmarshal(file);
            names = genericName.getNames();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return names;
    }
}