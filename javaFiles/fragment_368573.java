public class SampleFrame extends JFrame {

    private static JTextArea txtInform = new JTextArea();
    private static final String TEXT = "*First*\nAll first information are here..\n\n\n\n" +
            "**Second**\nAll second information are here..\n\n\n\n" +
            "***Third***\nAll third information are here..\n\n\n\n" +
            "****Fourth****\nAll fourth information are here..\n\n\n\n" +
            "*****Fifth*****\nAll fifth information are here..";

    public SampleFrame() {

        initComponents();
    }

    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane(txtInform);
        JButton firstButton = new JButton("First Button");
        JButton secondButton = new JButton("Second Button");
        JButton thirdButton = new JButton("Third Button");
        JButton fourthButton = new JButton("Fourth Button");
        JButton fifthButton = new JButton("Fifth Button");

        firstButton.addActionListener(new MyActionListener("*First*"));
        secondButton.addActionListener(new MyActionListener("**Second**"));
        thirdButton.addActionListener(new MyActionListener("***Third***"));
        fourthButton.addActionListener(new MyActionListener("****Fourth****"));
        fifthButton.addActionListener(new MyActionListener("*****Fifth*****"));

        txtInform.setText(TEXT);
        txtInform.setColumns(20);
        txtInform.setRows(5);
        txtInform.setLineWrap(true);
        txtInform.setWrapStyleWord(true);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(secondButton, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstButton, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thirdButton, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fourthButton, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fifthButton, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 265,
                            GroupLayout.PREFERRED_SIZE).addContainerGap(71, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(firstButton, GroupLayout.PREFERRED_SIZE, 30,
                            GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(secondButton, GroupLayout.PREFERRED_SIZE, 31,
                            GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thirdButton, GroupLayout.PREFERRED_SIZE, 31,
                            GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fourthButton, GroupLayout.PREFERRED_SIZE, 32,
                            GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fifthButton, GroupLayout.PREFERRED_SIZE, 32,
                            GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 305,
                            GroupLayout.PREFERRED_SIZE).addContainerGap(90, Short.MAX_VALUE)));

        setSize(new java.awt.Dimension(595, 477));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class MyActionListener implements ActionListener {

        private int offset, length;
        private final Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.BLUE);

        private MyActionListener(String chapter) {

            offset = TEXT.indexOf(chapter);
            length = chapter.length();
        }

        public void actionPerformed(ActionEvent e) {

            txtInform.setCaretPosition(offset);
            txtInform.getHighlighter().removeAllHighlights();
            try {
                txtInform.getHighlighter().addHighlight(offset, offset + length, painter);
            } catch (BadLocationException ble) {
                ble.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new SampleFrame().setVisible(true);
            }
        });
    }
}