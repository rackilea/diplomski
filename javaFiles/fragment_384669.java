public class DontStretchMyTextArea {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(1440, 900);
        window.setTitle("W: " + window.getWidth() + " H: " + window.getHeight());
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        window.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        JTextArea mainTextArea = new JTextArea( "This is the main text area" , 10 , 30 ); //here you can set how many rows/columns you want,
                                                                                          //but anyway GridBagLayout will recalculate size of component
                                                                                          //based on gbc.fill, weights and surrounding components
        //mainTextArea.setLayout(new GridLayout());
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(mainTextArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints panelGBC = new GridBagConstraints();

            panelGBC.weightx = 1;                    //I want to fill whole panel with JTextArea
            panelGBC.weighty = 1;                    //so both weights =1
            panelGBC.fill = GridBagConstraints.BOTH; //and fill is set to BOTH

            panel.add(scroll, panelGBC);
            panel.setBackground(Color.gray);//this shouldn't be visible


        gbc.weightx = 1;
        gbc.weighty = 0;
        window.add(panel, gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx++;
        window.add(new JLabel(), gbc); //GridBagLayout always needs component with both weights =1

        SwingUtilities.invokeLater(() -> { //we get our frame on EDT
            window.pack();
            window.setVisible(true);
        });
    }
}