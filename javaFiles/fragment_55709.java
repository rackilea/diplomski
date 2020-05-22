import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLTableExample {

    public static void main(String[] args) {
        new XMLTableExample();
    }

    public XMLTableExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JTable table = new JTable();
                try {
                    table.setModel(new XMLTableModel(new File("Html1.xml")));
                } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class XMLTableModel extends AbstractTableModel {

        protected static final String[] COLUMN_NAMES = {
            "Number",
            "Priority",
            "State",
            "Assigned",
            "Description",
            "Task"
        };
        private List<MSEntity> rows;

        public XMLTableModel(File file) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
            rows = new ArrayList<>(25);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(file);

            setDocument(dom);
        }

        protected String getMSValue(Node msNode, String name) throws XPathExpressionException {
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expression = xpath.compile("S[@N='" + name + "']");
            Node sNode = (Node)expression.evaluate(msNode, XPathConstants.NODE);
            return sNode != null ? sNode.getTextContent() : null;
        }

        @Override
        public int getRowCount() {
            return rows.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        public MSEntity getEntityAtRow(int row) {
            return rows.get(row);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            MSEntity entity = getEntityAtRow(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = entity.getNumber();
                    break;
                case 1:
                    value = entity.getPriority();
                    break;
                case 2:
                    value = entity.getState();
                    break;
                case 3:
                    value = entity.getAssigned();
                    break;
                case 4:
                    value = entity.getDesc();
                    break;
                case 5:
                    value = entity.getTask();
                    break;
            }
            return value;
        }

        public void setDocument(Document dom) throws XPathExpressionException {

            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expression = xpath.compile("/Objs/Obj/MS");
            NodeList nl = (NodeList)expression.evaluate(dom, XPathConstants.NODESET);
            for (int index = 0; index < nl.getLength(); index++) {
                Node node = nl.item(index);
                String number = getMSValue(node, "Number");
                String priority = getMSValue(node, "Priority");
                String state = getMSValue(node, "State");
                String assigned = getMSValue(node, "Assigned");
                String desc = getMSValue(node, "Short_desc");
                String task = getMSValue(node, "Task");

                MSEntity entity = new MSEntity(number, priority, state, assigned, desc, task);
                rows.add(entity);
            }

            fireTableDataChanged();

        }

        public class MSEntity {
            private final String number;
            private final String priority;
            private final String state;
            private final String assigned;
            private final String desc;
            private final String task;

            public MSEntity(String number, String priority, String state, String assigned, String desc, String task) {
                this.number = number;
                this.priority = priority;
                this.state = state;
                this.assigned = assigned;
                this.desc = desc;
                this.task = task;
            }

            public String getAssigned() {
                return assigned;
            }

            public String getDesc() {
                return desc;
            }

            public String getNumber() {
                return number;
            }

            public String getPriority() {
                return priority;
            }

            public String getState() {
                return state;
            }

            public String getTask() {
                return task;
            }

        }

    }

}