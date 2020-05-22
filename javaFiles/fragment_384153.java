import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.lang.reflect.Field;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class PixelArtistGUI extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                PixelArtistGUI frame = new PixelArtistGUI();
                frame.setVisible(true);
            }
        });
    }

    String colors[] = {"Red", "Orange", "Yellow", "Green", "Blue", "Magenta", "Black", "White"};
    JComboBox colorList = new JComboBox(colors);

    public PixelArtistGUI() {
        setTitle("PixelArtist");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.setPreferredSize(new Dimension(400, 450));

        // Content Pane
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);

        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{125, 125, 125};
        gbl_contentPane.rowHeights = new int[]{360, 15};
        contentPane.setLayout(gbl_contentPane);

        JLabel colorSelect = new JLabel("Select Color:");
        colorSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
        colorSelect.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_colorSelect = new GridBagConstraints();
        gbc_colorSelect.insets = new Insets(5, 0, 0, 0);
        gbc_colorSelect.gridx = 0;
        gbc_colorSelect.anchor = GridBagConstraints.SOUTH;
        gbc_colorSelect.fill = GridBagConstraints.BOTH;
        gbc_colorSelect.gridy = 1;
        contentPane.add(colorSelect, gbc_colorSelect);
        GridBagConstraints gbc_colorList = new GridBagConstraints();
        gbc_colorList.anchor = GridBagConstraints.SOUTH;
        gbc_colorList.fill = GridBagConstraints.BOTH;
        gbc_colorList.insets = new Insets(5, 0, 0, 0);
        gbc_colorList.gridx = 1;
        gbc_colorList.gridy = 1;
        contentPane.add(colorList, gbc_colorList);

        JButton screenshotButton = new JButton("Save Screenshot");
        GridBagConstraints gbc_screenshotButton = new GridBagConstraints();
        gbc_screenshotButton.anchor = GridBagConstraints.SOUTH;
        gbc_screenshotButton.fill = GridBagConstraints.BOTH;
        gbc_screenshotButton.insets = new Insets(5, 0, 0, 0);
        gbc_screenshotButton.gridx = 2;
        gbc_screenshotButton.gridy = 1;
        contentPane.add(screenshotButton, gbc_screenshotButton);

        String[] colHeadings = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        int numRows = 16;
        PixelModel model = new PixelModel(numRows, colHeadings.length);
        model.setColumnIdentifiers(colHeadings);

        JTable table_1 = new JTable(model);
        table_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                TableCellEditor editor = table_1.getCellEditor();
                if (editor != null) {
                    if (editor.stopCellEditing()) {
                        editor.cancelCellEditing();
                    }
                }
            }
        });
        table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        table_1.setRowSelectionAllowed(false);
        table_1.setDefaultRenderer(Object.class, new CustomRenderer());
        table_1.setDefaultEditor(Object.class, new CustomEditor());

        GridBagConstraints gbc_table_1 = new GridBagConstraints();
        gbc_table_1.gridwidth = 3;
        gbc_table_1.fill = GridBagConstraints.BOTH;
        gbc_table_1.gridx = 0;
        gbc_table_1.gridy = 0;
        contentPane.add(table_1, gbc_table_1);
        table_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_1.setCellSelectionEnabled(true);
        table_1.setRowHeight(23);

        this.pack();
    }

    public class CustomRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            super.getTableCellRendererComponent(table, null, false, hasFocus, row, column);
            if (value != null && value instanceof Color) {
                setBackground((Color) value);
            } else {
                setBackground(null);
            }
            return this;
        }
    }

    public class CustomEditor extends AbstractCellEditor implements TableCellEditor {

        private JPanel panel;

        public CustomEditor() {
            this.panel = new JPanel();
        }

        @Override
        public Object getCellEditorValue() {
            Color c = null;
            try {
                String cString = colorList.getSelectedItem().toString().toLowerCase();
                Field field = Class.forName("java.awt.Color").getField(cString);
                c = (Color) field.get(null);
            } catch (Exception e) {
                c = null;
            }
            return c;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            panel.setBackground((Color) getCellEditorValue());
            return panel;
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return true;
        }

    }

    // Custom table model to make the cells selectable but not editable
    public class PixelModel extends DefaultTableModel {

        PixelModel(int numRows, int numColumns) {
            super(numRows, numColumns);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return true;
        }

    }
}