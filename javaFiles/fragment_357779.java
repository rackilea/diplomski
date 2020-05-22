class TimerDocumentListener implements DocumentListener {

    private Document doc;
    private Timer timer;

    public TimerDocumentListener() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (doc != null) {
                    try {
                        String text = doc.getText(0, doc.getLength());
                        statusLabel.setText(text);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(TimerDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        timer.setRepeats(false);
    }

    public void insertUpdate(DocumentEvent e) { set(e); }
    public void removeUpdate(DocumentEvent e) { set(e); }
    public void changedUpdate(DocumentEvent e) { set(e); }

    private void set(DocumentEvent e) {
        if (timer.isRunning()) {
            timer.restart();
        } else {
            this.doc = e.getDocument();
            timer.start();
        }
    }
}