public static void testDocument () {
        final JTextField tf = new JTextField();
        tf.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                System.out.println(tf.getText());
                try {
                    System.out.println("printing: " + arg0.getDocument().getDefaultRootElement().getDocument().getText(0,arg0.getDocument().getDefaultRootElement().getDocument().getLength()));
                } catch (BadLocationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                System.out.println(tf.getText());               
                try {
                    System.out.println("printing: " + arg0.getDocument().getDefaultRootElement().getDocument().getText(0,arg0.getDocument().getDefaultRootElement().getDocument().getLength()));
                } catch (BadLocationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                System.out.println(tf.getText());               
                try {
                    System.out.println("doc: " + arg0.getDocument().getDefaultRootElement().getDocument().getText(0,arg0.getDocument().getDefaultRootElement().getDocument().getLength()));
                } catch (BadLocationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        WindowUtilities.visualize(tf);
    }