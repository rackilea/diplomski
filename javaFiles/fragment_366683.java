public class Test extends JFrame implements ActionListener {
    private JComboBox<Integer> yearBox;
    private JComboBox<Integer> monthBox;
    private JComboBox<Integer> dayBox;

    public Test() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        yearBox = new JComboBox<>();
        for (int i = 1940; i <= LocalDateTime.now().getYear(); i++) {
            yearBox.addItem(i);
        }
        yearBox.addActionListener(this);

        monthBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            monthBox.addItem(i);
        }
        monthBox.addActionListener(this);

        dayBox = new JComboBox<>();

        add(new JLabel("year:"));
        add(yearBox);
        add(new JLabel("month:"));
        add(monthBox);
        add(new JLabel("day:"));
        add(dayBox);

        //Start with current year selected
        yearBox.setSelectedIndex(yearBox.getItemCount() - 1);

        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int year = (int) yearBox.getSelectedItem();
        int month = (int) monthBox.getSelectedItem();
        int daysInThisMonth = LocalDate.of(year, month, 1).lengthOfMonth();
        int previousSelection = dayBox.getSelectedItem() != null ? (int) dayBox.getSelectedItem() : 1;
        dayBox.removeAllItems();
        for (int i = 1; i <= daysInThisMonth; i++) {
            dayBox.addItem(i);
        }
        if (previousSelection >= dayBox.getItemCount())
            //select last index of month
            dayBox.setSelectedIndex(dayBox.getItemCount() - 1);
        else
            dayBox.setSelectedItem(previousSelection);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test().setVisible(true));
    }

}