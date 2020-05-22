public static void main(String[] args) {
        //Create GUI on EDT Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                  JFrame frame = new JFrame("JScroll Pane Test");
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

                  JTextArea txtNotes = new JTextArea();
                  txtNotes.setText("Hello World");
                  JScrollPane scrollPane = new JScrollPane(txtNotes);
                  frame.add(scrollPane);//add components

                  frame.pack();
                  frame.setVisible(true);//show (after adding components)
            }
        });
}