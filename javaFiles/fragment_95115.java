import java.awt.Dimension;
import java.io.File;
import javax.swing.*;
import javax.xml.bind.*;

public class TestTableMarshall {

    private static final String INPUT_FILE = "src/table/autos.xml";
    private static final String OUTPUT_FILE = "src/table/autos1.xml";

    public static void main(String[] args) throws Exception {
        AutoModel model = unmarshal(INPUT_FILE);
        JTable table = new JTable(model) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return getPreferredSize();
            }
        };
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
        marshal(model, OUTPUT_FILE);

    }

    private static void marshal(AutoModel model, String file) throws Exception {
        JAXBContext context = JAXBContext.newInstance(AutoModel.class);
        Marshaller marshaller = context.createMarshaller();
        File f= new File(file);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(model, f);
    }

    private static AutoModel unmarshal(String file) throws Exception {
        JAXBContext context = JAXBContext.newInstance(AutoModel.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        AutoModel model = (AutoModel)unmarshaller.unmarshal(new File(file));
        return model;
    }
}