public static void main(String[] args) {
    UIManager.installLookAndFeel("CustomMetal", "laf.CustomMetalLookAndFeel");
    try {
        UIManager.setLookAndFeel("laf.CustomMetalLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
        e1.printStackTrace();
    }
    UIManager.getLookAndFeelDefaults().put("Panel.background", new ColorUIResource(Color.RED));

    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JButton j = new JButton("100000");
    j.addActionListener(e -> {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(f);
    });
    p.add(j);
    f.add(p);
    f.pack();
    f.setVisible(true);
}