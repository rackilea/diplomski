public void init()
{
    fr = new JFrame("Lab 2");
    fr.setMinimumSize(new Dimension(1350, 650));
    fr.setMaximumSize(fr.getMinimumSize());
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // JPanel glowny = new JPanel(new BorderLayout());
    // glowny.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    // glowny.add(getBorderCenter(), BorderLayout.CENTER); 
    // fr.add(glowny);

    setLayout(new BorderLayout();
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    add(getBorderCenter(), BorderLayout.CENTER); 
    fr.add(this);

    fr.pack();
    fr.setVisible(true);
}