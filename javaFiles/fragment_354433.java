public class TestTableModel {

    public static void main(String[] args) {
        new TestTableModel();
    }

    public TestTableModel() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final MyTableModel tableModel = new MyTableModel();
                final JTable table = new JTable(tableModel);

                JButton addButton = new JButton("Add");
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tableModel.add();
                    }
                });
                JButton updateButton = new JButton("Update");
                updateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = table.getSelectedRow();
                        if (row > -1) {
                            table.setValueAt("Banana", row, 0);
                        }
                    }
                });

                JPanel buttonPane = new JPanel();
                buttonPane.add(addButton);
                buttonPane.add(updateButton);

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.add(buttonPane, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Person {

        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

    public class MyTableModel extends AbstractTableModel {

        private List<Person> lstPeople;

        public MyTableModel() {
            lstPeople = new ArrayList<Person>(25);
            lstPeople.add(new Person("Darryl Garton", randomAge()));
            lstPeople.add(new Person("Neil Willison", randomAge()));
            lstPeople.add(new Person("Darryl Hege", randomAge()));
            lstPeople.add(new Person("Karina Jerry", randomAge()));
            lstPeople.add(new Person("Erik Leddy", randomAge()));
            lstPeople.add(new Person("Chandra Kehrer", randomAge()));
            lstPeople.add(new Person("Katy Sapien", randomAge()));
            lstPeople.add(new Person("Lonnie Blakes", randomAge()));
            lstPeople.add(new Person("Kelly Ruocco", randomAge()));
            lstPeople.add(new Person("Fernando Mckinnie", randomAge()));
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        protected int randomAge() {

            return (int)Math.round(Math.random() * 99) + 1;

        }

        @Override
        public int getRowCount() {
            return lstPeople.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int column) {
            String name = null;
            switch (column) {
                case 0:
                    name = "Name";
                    break;
                case 1:
                    name = "Age";
                    break;
            }
            return name;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class clazz = String.class;
            switch (columnIndex) {
                case 1:
                    clazz = Integer.class;
                    break;
            }
            return clazz;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object value = null;
            Person person = lstPeople.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    value = person.getName();
                    break;
                case 1:
                    value = person.getAge();
                    break;
            }
            return value;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Person person = lstPeople.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    if (aValue instanceof String) {
                        person.setName(aValue.toString());
                    }
                    break;
                case 1:
                    if (aValue instanceof Integer) {
                        person.setAge((Integer)aValue);
                    }
                    break;
            }
            fireTableCellUpdated(rowIndex, columnIndex);
        }

        public void add() {

            lstPeople.add(new Person());
            fireTableRowsInserted(lstPeople.size() - 1, lstPeople.size() - 1);

        }

    }

}