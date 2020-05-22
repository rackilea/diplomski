public static class PrintForm extends JPanel {

    public PrintForm() {
        setLayout(new GridBagLayout());
        JLabel label = new JLabel("This is a label");
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        try {
            label.setIcon(new ImageIcon(ImageIO.read(new File("C:\\hold\\thumbnails\\_cg_1009___Afraid___by_Serena_Clearwater.png"))));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(label, gbc);

        JRadioButton rb = new JRadioButton("Open to suggestions");
        rb.setSelected(true);
        gbc.gridy++;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(rb, gbc);
    }

}