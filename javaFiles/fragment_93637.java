public class HeaderPane extends JPanel {

    public HeaderPane() {
        setLayout(new GridBagLayout());

        add(new JButton("Tab 1"));
        add(new JButton("Tab 2"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.BASELINE_TRAILING;

        add(new JButton("Minimize"), gbc);
        add(new JButton("Maximise"));
        add(new JButton("Close"));          
    }

}