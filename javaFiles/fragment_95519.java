public class MenuPage extends JFrame implements ActionListener {
    private JButton                     btnCart, btnExit;
    private JPanel                      leftPane, rightPane;
    private Container                   cont;

    private static final List<String>   LABELS_TEXT = Arrays.asList("Formal Shirts","T - Shirts", //
                                                            "Sweater","Jeans","Hats","Bags");

    public MenuPage() {
        super("Menu");
        cont = getContentPane();
        cont.setLayout(new BorderLayout());

        leftPane = new JPanel();
        leftPane.setLayout(new GridLayout(9,1));
        leftPane.setBorder(new TitledBorder("Menus"));

        List<JPopupMenu> popMenus = buildPopMenus();
        for (int i=0 ; i<LABELS_TEXT.size() ; i++) {
            final int j = i;
            JLabel label = new JLabel(LABELS_TEXT.get(i),SwingConstants.CENTER);
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    popMenus.get(j).setVisible(false);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    Point loc = label.getLocationOnScreen();
                    loc.translate(label.getWidth(),label.getHeight());
                    popMenus.get(j).setLocation(loc);
                    popMenus.get(j).setVisible(true);
                }
            });
            leftPane.add(label);
        }

        btnCart = new JButton("Cart");
        btnExit = new JButton("Exit");

        cont.add(leftPane,BorderLayout.WEST);
        leftPane.setOpaque(true);

        btnCart.addActionListener(this);
        btnExit.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        validate();
    }

    private List<JPopupMenu> buildPopMenus() {
        return LABELS_TEXT.stream().map(text -> { 
            JPopupMenu popMenu = new JPopupMenu();
            popMenu.add(new JMenuItem(text));
            return popMenu;
        })
        .collect(Collectors.toList());
    }

    public void actionPerformed(ActionEvent menu) {
        if (menu.getSource() == btnCart) {
            dispose();
        }

        else if (menu.getSource() == btnExit) {
            dispose();
            // new WelcomePage();
        }
    }

    public static void main(String args[]) {
        MenuPage wp = new MenuPage();
    }
}