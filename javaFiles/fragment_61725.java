public Game04() {

        //layout manager will is used for JTextArea only
        setLayout(new GridBagLayout());
        JTextArea quoteText = new JTextArea();
        quoteText.setText("Default Text");
        add(quoteText);
  }