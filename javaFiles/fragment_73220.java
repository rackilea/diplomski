public class HistgramEqualizerApp extends JFrame {

    private JButton increaseContrastButton = new JButton(">>");;
    private JButton decreaseContrastButton = new JButton("<<");;

    public HistgramEqualizerApp(String filename) throws IOException {

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 40));
        buttonsPanel.add(decreaseContrastButton);
        buttonsPanel.add(increaseContrastButton);
        getContentPane().add(new JLabel(new ImageIcon(filename)));
        getContentPane().add(buttonsPanel, BorderLayout.PAGE_START);
    }

    public static void main(String args[]) throws IOException {

        HistgramEqualizerApp histApp = new HistgramEqualizerApp(args[0]);
        histApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        histApp.pack();
        histApp.setVisible(true);
    }
}