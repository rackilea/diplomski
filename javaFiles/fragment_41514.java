public class CBGroup extends Frame implements ItemListener {
    String msg = "";
    Checkbox windows, android, solaris, mac;
    CheckboxGroup cbg;

    public CBGroup() {
        super("");
        // Use a flow layout
        setLayout(new FlowLayout());

        // Create a checkbox group
        cbg = new CheckboxGroup();

        // Create the checkboxes and include them in the group
        windows = new Checkbox("windows", cbg, true);
        android = new Checkbox("android", cbg, false);
        solaris = new Checkbox("solaris", cbg, false);
        mac = new Checkbox("mac", cbg, false);

        add(windows);
        add(android);
        add(solaris);
        add(mac);

        // Add item listeners
        windows.addItemListener(this);
        android.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }

//  // Display current state of the check boxes
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        msg = "Current selection: ";
        msg += cbg.getSelectedCheckbox().getLabel();
        g.drawString(msg, 20, 120);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CBGroup appwin = new CBGroup();

            appwin.setSize(new Dimension(240, 180));
            appwin.setTitle("CBGroup");
            appwin.setVisible(true);
        });
    }
}