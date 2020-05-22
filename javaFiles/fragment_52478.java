@SuppressWarnings("serial")
    public class Window extends JFrame {

        // Fields
        // specify here all private fields that you want in you application like JLabels etc...
        private JList monthsList;
        private String[] months = {"January", "February", "March" , "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        // no args constructor
        public Window() {
            createUI();
        }
        @SuppressWarnings({ "unchecked", "rawtypes" })
        private void createUI() {
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            // Months Selection
            monthList = new JList(months);
            monthList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            monthList.setVisibleRowCount(5);
            monthList.setBounds(400, 16, 100, 50);
            JScrollPane monthScroll = new JScrollPane(monthsList);
            monthScroll.setBounds(180, 16, 135, 400);
            contentPane.add(monthsScroll);


            // set the content Pane window
            setTitle("Months");
            setSize(100,100);
            setVisible(true);

            }

        public void buttonActionPerformed(ActionEvent event) {

            this.buttonPressed = true;

            @SuppressWarnings("deprecation")
            Object[] monthObjects = monthsList.getSelectedValues();
            this.monthsSelected = Arrays.copyOf(monthObjects,monthObjects.length, String[].class);

            }

        // Method to diagnose Start button clicked to use in the Main
        public boolean VerifyButtonPressed() {

            return buttonPressed == true ? true : false;

        }

        // Methods to set the user specified value to the CurrentInput class fields

        public String[] getMonthsSelected() {
            return monthsSelected;
        }


    }