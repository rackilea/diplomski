public class Test {

public static void main(String[] args) {
    Test test = new Test();
    test.test();
}

private JFrame frame;
private JPanel panel;
private JPopupMenu menu;
private JTextField field;

public Test() {
    frame = new JFrame();
    frame.setSize(new Dimension(200, 200));
    frame.getContentPane().add(getPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

private JPanel getPanel() {
    if (panel == null) {
        panel = new JPanel();
        panel.setComponentPopupMenu(getMenu());
        panel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                menu.show(panel, e.getX(), e.getY());
            }
        });
    }
    return panel;
}

private JPopupMenu getMenu() {
    if (menu == null) {
        menu = new JPopupMenu() {

            @Override
            public void setVisible(boolean visible) {
                super.setVisible(visible);
                if (visible) {
                    getField().requestFocus();
                }
            }
        };
        menu.add(getField());
    }
    return menu;
}

private JTextField getField() {
    if (field == null) {
        field = new JTextField();
        field.setColumns(10);
        field.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getMenu().setVisible(false);
            }
        });
    }
    return field;
}

public void test() {
    frame.setVisible(true);
}
}