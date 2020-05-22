public class BadLayout {

  public static void main(String[] args) {
    new BadLayout();
  }

  public BadLayout() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TestPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

      }
    });
  }

  public class TestPane extends JPanel {

    private JTextField searchField;
    private JButton searchButton;
    private JTextArea searchResults;

    public TestPane() {
      setLayout(new BorderLayout());

      searchResults = new JTextArea();
      searchResults.setLineWrap(true);
      searchResults.setWrapStyleWord(true);
      JScrollPane scrollPane = new JScrollPane(searchResults);

      JPanel results = new JPanel(new BorderLayout());
      results.setBorder(new EmptyBorder(4, 8, 8, 8));
      results.add(scrollPane);
      add(results);

      JPanel search = new JPanel(new GridBagLayout());
      search.setBorder(new EmptyBorder(8, 8, 4, 8));
      searchField = new JTextField(12);
      searchButton = new JButton("Search");

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 1;
      gbc.insets = new Insets(0, 0, 0, 4);
      search.add(searchField, gbc);

      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.gridx++;
      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 0;
      search.add(searchButton, gbc);

      add(search, BorderLayout.NORTH);
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(200, 400);
    }
  }  
}