public DesignGridTest(){

        JFrame frame = new JFrame("Example 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel masterpanel = new JPanel();
        DesignGridLayout masterlayout = new DesignGridLayout(masterpanel);

        JCheckBox chk1 = new JCheckBox("Check Box1");
        masterlayout.row().left().add(chk1);    

        JPanel panel1 = new JPanel();
        JTable table1 = new JTable();
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        panel1.add(table1);
        final IRow row1 = masterlayout.row().grid().add(panel1);
        chk1.setSelected(true);
        chk1.addItemListener(new ItemListener()
        {
            @Override public void itemStateChanged(ItemEvent event)
            {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    row1.show();
                else
                    row1.hide();
                frame.pack();
            }
        });     
        frame.add(masterpanel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String a[]){new DesignGridTest();}