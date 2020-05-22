import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class TestJTable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View_MainFrame viewMainFrame = new View_MainFrame();
            viewMainFrame.setPresenter(
                    new Presenter(viewMainFrame, new Model_Flightplan(viewMainFrame)));
        });
    }
}

class View_MainFrame {
    AppSingleton appSingleton = AppSingleton.getInstance();
    private Presenter presenter;
    private JPanel panelContext;

    private JFrame frame;

    public JPanel pnlDep;
    public JPanel pnlDest;
    public JPanel pnlAlt;
    public JPanel pnlWindsAloft;
    public JPanel panelButtons;
    public JButton btnFlightplan;
    public JPanel panelButtonsAdd;
    public JButton btnFlightplanDummy;
    public JPanel pnlDepAirport;
    private JButton btnAddDep;

    private javax.swing.JPanel pnlDestAirport;
    public JButton btnAddDest;

    private javax.swing.JPanel pnlAltAirport;
    public JButton btnAddAlt;

    private javax.swing.JPanel pnlWindsAloftInfo;
    private javax.swing.JPanel pnlWindsAloftTable;
    public JButton btnPnlDeparture;
    public JButton btnPnlDestination;
    public JButton btnPnlAlternate;
    public JButton btnPnlWindsAloft;

    public View_MainFrame() {
        createUI();
    }

    private void createUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("iGoDispatch IXEG Boeing-733");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(
                new javax.swing.BoxLayout(frame.getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        Dimension frameSize = new Dimension(1050, 700);
        Dimension frameSizeMin = new Dimension(500, 200);
        frame.setPreferredSize(frameSize);
        frame.setMinimumSize(frameSizeMin);

        createPanelButtons();
        createPanelButtonsAdd();
        createPanelDeparture();
        createPanelDestination();
        createPanelAlternate();
        pnlWindsAloft = new JPanel();
        pnlWindsAloft.setLayout(new java.awt.BorderLayout());
        createPanelWindsAloft();

        setPanelContext(new JPanel());
        getPanelContext().setLayout(new java.awt.CardLayout());
        frame.getContentPane().add(getPanelContext(), java.awt.BorderLayout.SOUTH);

        getPanelContext().add(pnlDep, "cardDep");
        getPanelContext().add(pnlDest, "cardDest");
        getPanelContext().add(pnlAlt, "cardAlt");
        getPanelContext().add(pnlWindsAloft, "cardWindsAloft");

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public JPanel getPanelContext() {
        return panelContext;
    }

    public void setPanelContext(JPanel panelContext) {
        this.panelContext = panelContext;
    }

    private void createPanelButtons() {
        panelButtons = new JPanel();
        panelButtons.setBorder(
                new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelButtons.setLayout(new java.awt.GridLayout(1, 0));
        Dimension panelButtonsMinSize = new Dimension(1050, 60);
        panelButtons.setMinimumSize(panelButtonsMinSize);

        btnFlightplan = new JButton();
        btnFlightplan.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        btnFlightplan.setText("Flightplan");
        btnFlightplan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFlightplan.setIconTextGap(5);
        btnFlightplan.setMaximumSize(new java.awt.Dimension(90, 70));
        btnFlightplan.setMinimumSize(new java.awt.Dimension(90, 70));
        btnFlightplan.setPreferredSize(new java.awt.Dimension(90, 70));
        btnFlightplan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFlightplan.addActionListener((java.awt.event.ActionEvent evt) -> {
            getPresenter().displayTabDep();
        });
        panelButtons.add(btnFlightplan);

        frame.getContentPane().add(panelButtons, java.awt.BorderLayout.NORTH);
    }

    private void createPanelButtonsAdd() {
        panelButtonsAdd = new JPanel();
        panelButtonsAdd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frame.getContentPane().add(panelButtonsAdd, java.awt.BorderLayout.CENTER);
        panelButtonsAdd.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        btnFlightplanDummy = new JButton();
        btnFlightplanDummy.setAlignmentY(0.0F);
        btnFlightplanDummy.setEnabled(false);
        btnFlightplanDummy.setVisible(false);
        btnFlightplanDummy.setMaximumSize(new java.awt.Dimension(50, 50));
        btnFlightplanDummy.setMinimumSize(new java.awt.Dimension(50, 50));
        btnFlightplanDummy.setPreferredSize(new java.awt.Dimension(50, 50));
        panelButtonsAdd.add(btnFlightplanDummy);

        addButtonsFlightplan();
    }

    public void addButtonsFlightplan() {
        removeButtons();
        Dimension buttonDim = new Dimension(150, 50);
        Font buttonFont = new Font("Helvetica", Font.PLAIN, 10);
        btnPnlDeparture = new JButton("DEP");
        btnPnlDeparture.setPreferredSize(buttonDim);
        btnPnlDeparture.setFont(buttonFont);
        btnPnlDeparture.setVisible(true);
        btnPnlDeparture.addActionListener((ActionEvent e) -> {
            getPresenter().displayTabDep();
        });

        panelButtonsAdd.add(btnPnlDeparture);

        btnPnlDestination = new JButton("ARR");
        btnPnlDestination.setPreferredSize(buttonDim);
        btnPnlDestination.setFont(buttonFont);
        btnPnlDestination.setVisible(true);
        btnPnlDestination.addActionListener((ActionEvent e) -> {
            getPresenter().displayTabDest();
        });
        panelButtonsAdd.add(btnPnlDestination);

        btnPnlAlternate = new JButton("ALT");
        btnPnlAlternate.setPreferredSize(buttonDim);
        btnPnlAlternate.setFont(buttonFont);
        btnPnlAlternate.setVisible(true);
        btnPnlAlternate.addActionListener((ActionEvent e) -> {
            getPresenter().displayTabAlt();
        });
        panelButtonsAdd.add(btnPnlAlternate);

        btnPnlWindsAloft = new JButton("WINDS");
        btnPnlWindsAloft.setPreferredSize(buttonDim);
        btnPnlWindsAloft.setFont(buttonFont);
        btnPnlWindsAloft.setVisible(true);
        btnPnlWindsAloft.addActionListener((ActionEvent e) -> {
            getPresenter().displayTabWindsAloft();
        });
        panelButtonsAdd.add(btnPnlWindsAloft);

        panelButtonsAdd.revalidate();
        panelButtonsAdd.repaint();
    }

    private void removeButtons() {
        panelButtonsAdd.removeAll();
        panelButtonsAdd.revalidate();
        panelButtonsAdd.repaint();
    }

    private void createPanelDeparture() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlDep = new JPanel();
        pnlDep.setLayout(new java.awt.BorderLayout());

        pnlDepAirport = new JPanel();
        pnlDepAirport.setLayout(new java.awt.GridBagLayout());

        btnAddDep = new JButton();
        btnAddDep.setText("ADD");
        btnAddDep.setMaximumSize(new java.awt.Dimension(75, 35));
        btnAddDep.setMinimumSize(new java.awt.Dimension(75, 35));
        btnAddDep.setPreferredSize(new java.awt.Dimension(75, 35));
        btnAddDep.addActionListener((java.awt.event.ActionEvent evt) -> {
            JFrame f = new JFrame();
            JDialog modalDialog = new JDialog(f, "Busy", Dialog.ModalityType.MODELESS);
            modalDialog.setSize(200, 100);
            modalDialog.setLocationRelativeTo(f);
            modalDialog.setUndecorated(true);
            modalDialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            modalDialog.getContentPane().setBackground(Color.WHITE);
            modalDialog.add(new JLabel("Please wait... ", JLabel.CENTER));
            modalDialog.setVisible(true);

            new Thread(() -> {
                getPresenter().addDeparture();
                SwingUtilities.invokeLater(() -> {
                    modalDialog.setVisible(false);
                    modalDialog.dispose();
                });
            }).start();
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pnlDepAirport.add(btnAddDep, gridBagConstraints);

        pnlDep.add(pnlDepAirport);
    }

    private void createPanelDestination() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlDest = new JPanel();
        pnlDest.setLayout(new java.awt.BorderLayout());

        pnlDestAirport = new javax.swing.JPanel();
        pnlDestAirport.setLayout(new java.awt.GridBagLayout());

        btnAddDest = new javax.swing.JButton();
        btnAddDest.setText("jButton1");
        btnAddDest.setMaximumSize(new java.awt.Dimension(75, 35));
        btnAddDest.setMinimumSize(new java.awt.Dimension(75, 35));
        btnAddDest.setPreferredSize(new java.awt.Dimension(75, 35));
        btnAddDest.addActionListener((java.awt.event.ActionEvent evt) -> {
            JFrame f = new JFrame();
            JDialog modalDialog = new JDialog(f, "Busy", Dialog.ModalityType.MODELESS);
            modalDialog.setSize(200, 100);
            modalDialog.setLocationRelativeTo(f);
            modalDialog.setUndecorated(true);
            modalDialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            modalDialog.getContentPane().setBackground(Color.WHITE);
            modalDialog.add(new JLabel("Please wait... ", JLabel.CENTER));
            modalDialog.setVisible(true);

            new Thread(() -> {
                getPresenter().addDestination();
                SwingUtilities.invokeLater(() -> {

                    modalDialog.setVisible(false);
                    modalDialog.dispose();

                });
            }).start();
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pnlDestAirport.add(btnAddDest, gridBagConstraints);

        pnlDest.add(pnlDestAirport);
    }

    private void createPanelAlternate() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlAlt = new JPanel();
        pnlAlt.setLayout(new java.awt.BorderLayout());

        pnlAltAirport = new JPanel();
        pnlAltAirport.setLayout(new java.awt.GridBagLayout());

        btnAddAlt = new JButton();
        btnAddAlt.setText("ADD");
        btnAddAlt.setMaximumSize(new java.awt.Dimension(75, 35));
        btnAddAlt.setMinimumSize(new java.awt.Dimension(75, 35));
        btnAddAlt.setPreferredSize(new java.awt.Dimension(75, 35));
        btnAddAlt.addActionListener((java.awt.event.ActionEvent evt) -> {
            JFrame f = new JFrame();
            JDialog modalDialog = new JDialog(f, "Busy", Dialog.ModalityType.MODELESS);
            modalDialog.setSize(200, 100);
            modalDialog.setLocationRelativeTo(f);
            modalDialog.setUndecorated(true);
            modalDialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            modalDialog.getContentPane().setBackground(Color.WHITE);
            modalDialog.add(new JLabel("Please wait... ", JLabel.CENTER));
            modalDialog.setVisible(true);

            new Thread(() -> {
                getPresenter().addAlternate();
                SwingUtilities.invokeLater(() -> {
                    modalDialog.setVisible(false);
                    modalDialog.dispose();
                });
            }).start();
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        pnlAltAirport.add(btnAddAlt, gridBagConstraints);

        pnlAlt.add(pnlAltAirport);
    }

    public void createPanelWindsAloft() {
        pnlWindsAloftInfo = new javax.swing.JPanel();
        pnlWindsAloftInfo.setLayout(new java.awt.GridLayout(1, 0));

        pnlWindsAloftTable = new javax.swing.JPanel();
        pnlWindsAloftTable.setLayout(new BorderLayout());

        javax.swing.JTable tblWindsAloft = new javax.swing.JTable(
                new Model_TableWindsAloft(createDataForWindsTable()));

        JScrollPane scrollWindsAloft = new JScrollPane(tblWindsAloft,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tblWindsAloft.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblWindsAloft.setFillsViewportHeight(true);
        pnlWindsAloftTable.add(scrollWindsAloft, BorderLayout.CENTER);

        pnlWindsAloftInfo.add(pnlWindsAloftTable);
        pnlWindsAloft.add(pnlWindsAloftInfo, java.awt.BorderLayout.CENTER);
    }

    public List<List<String>> createDataForWindsTable() {
        List<List<String>> finalResult = new ArrayList<>();

        System.out.println("SIZE: " + finalResult.size());

        for (int i = 0; i < appSingleton.flightPlanShared.size(); i++) {
            String icao;
            String name;
            String type;

            if (appSingleton.flightPlanShared.get(i).size() > 2) {
                icao = appSingleton.flightPlanShared.get(i).get(2);
                name = appSingleton.flightPlanShared.get(i).get(1);
                type = appSingleton.flightPlanShared.get(i).get(0);
            } else {
                icao = "";
                name = "";
                type = "";
            }

            List<String> components = new ArrayList<>();

            components.add(icao);
            components.add(name);
            components.add(type);

            System.out.println("COMPONENTS: " + components);

            finalResult.add(components);
        }

        /*
         * THIS WORKS! String a1 = "LAS VEGAS/MC CARRAN "; String a2 = "KLAS";
         * String a3 = "PORTDEP";
         * 
         * List<String> a = new ArrayList<>(); a.add(a1); a.add(a2); a.add(a3);
         * 
         * String b1 = "LOS ANGELES INTL"; String b2 = "KLAX"; String b3 =
         * "PORTDEST"; List<String> b = new ArrayList<>(); b.add(b1); b.add(b2);
         * b.add(b3);
         * 
         * String c1 = "SEATTLE-TACOMA INTL"; String c2 = "KSEA"; String c3 =
         * "PORTALT"; List<String> c = new ArrayList<>(); c.add(c1); c.add(c2);
         * c.add(c3);
         * 
         * finalResult.add(a); finalResult.add(b); finalResult.add(c);
         */

        System.out.println("DATA CREATED: " + finalResult);

        return finalResult;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}

class Presenter {
    private final View_MainFrame viewMainFrame;
    private final Model_Flightplan model;

    public Presenter(View_MainFrame viewMainFrame, Model_Flightplan model) {
        this.viewMainFrame = viewMainFrame;
        this.model = model;
    }

    public void displayTabDep() {
        CardLayout card = (CardLayout) viewMainFrame.getPanelContext().getLayout();
        card.show(viewMainFrame.getPanelContext(), "cardDep");
        viewMainFrame.addButtonsFlightplan();
        viewMainFrame.btnPnlDeparture.setEnabled(false);
    }

    public void displayTabDest() {
        CardLayout card = (CardLayout) viewMainFrame.getPanelContext().getLayout();
        card.show(viewMainFrame.getPanelContext(), "cardDest");
        viewMainFrame.addButtonsFlightplan();
        viewMainFrame.btnPnlDestination.setEnabled(false);
    }

    public void displayTabAlt() {
        CardLayout card = (CardLayout) viewMainFrame.getPanelContext().getLayout();
        card.show(viewMainFrame.getPanelContext(), "cardAlt");
        viewMainFrame.addButtonsFlightplan();
        viewMainFrame.btnPnlAlternate.setEnabled(false);
    }

    public void displayTabWindsAloft() {
        CardLayout card = (CardLayout) viewMainFrame.getPanelContext().getLayout();
        card.show(viewMainFrame.getPanelContext(), "cardWindsAloft");

        viewMainFrame.addButtonsFlightplan();
        viewMainFrame.btnPnlWindsAloft.setEnabled(false);

        viewMainFrame.createPanelWindsAloft();
    }

    public void addDeparture() {
        model.addDepartureAirport();
    }

    public void addDestination() {
        model.addDestinationAirport();
    }

    public void addAlternate() {
        model.addAlternateAirport();
    }
}

class Model_TableWindsAloft extends AbstractTableModel {

    String[] columnNames = { "ICAO", "Name", "Type" };

    private List<List<String>> tableData = new ArrayList<>();

    public Model_TableWindsAloft(List<List<String>> tableData) {
        this.tableData = tableData;
        System.out.println("CONSTRUCTOR? " + tableData);
    }

    @Override
    public int getRowCount() {
        System.out.println("DATA COUNT? " + tableData.size());
        return (tableData.size());
    }

    @Override
    public int getColumnCount() {
        return (columnNames.length);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        System.out.println("WHAT IS DATA 1? " + tableData);

        List<String> data = tableData.get(rowIndex);

        System.out.println("WHAT IS DATA 2? " + data);

        if (data.size() >= 3) {
            switch (columnIndex) {
            case 0:
                return data.get(0);
            case 1:
                return data.get(1);
            case 2:
                return data.get(2);
            default:
                return null;
            }
        } else {
            return null;
        }
    }
}

class Model_Flightplan {
    AppSingleton appSingleton = AppSingleton.getInstance();
    private Presenter presenter;
    private View_MainFrame viewMainFrame;

    public Model_Flightplan(View_MainFrame viewMainFrame) {
        this.viewMainFrame = viewMainFrame;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void addDepartureAirport() {
        List<String> component = new ArrayList<>();
        component.add("KLAS");
        component.add("KLAS");
        component.add("KLAS");

        appSingleton.flightPlanShared.set(0, component);
    }

    public void addDestinationAirport() {
        List<String> component = new ArrayList<>();
        component.add("KLAX");
        component.add("KLAX");
        component.add("KLAX");

        appSingleton.flightPlanShared.set((appSingleton.flightPlanShared.size() - 2), component);
    }

    public void addAlternateAirport() {
        List<String> component = new ArrayList<>();
        component.add("KSEA");
        component.add("KSEA");
        component.add("KSEA");

        appSingleton.flightPlanShared.set((appSingleton.flightPlanShared.size() - 1), component);
    }
}

class AppSingleton {
    private static AppSingleton instance = null;

    public List<List<String>> flightPlanShared = new ArrayList<List<String>>() {
        {
            add(Arrays.asList(""));
            add(Arrays.asList(""));
            add(Arrays.asList(""));
        }
    };

    private AppSingleton() {

    }

    public static AppSingleton getInstance() {
        if (instance == null) {
            instance = new AppSingleton();
        }
        return instance;
    }
}