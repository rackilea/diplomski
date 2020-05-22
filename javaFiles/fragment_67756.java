public class TestComboBox04 {

  public static void main(String[] args) {
    new TestComboBox04();
  }

  public TestComboBox04() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }

        JComboBox targetCombo = new JComboBox();
        targetCombo.setRenderer(new DefaultListCellRenderer() {
          public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
              MyObj myObj = (MyObj) value;
              setText(myObj.getName());
            }
            return this;
          }
        });
        targetCombo.addItem(new MyObj("A"));
        targetCombo.addItem(new MyObj("B"));
        targetCombo.addItem(new MyObj("C"));
        targetCombo.addItem(new MyObj("D"));

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.add(targetCombo);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

      }
    });
  }

  public class MyObj {

    private String name;

    public MyObj(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

  }

}