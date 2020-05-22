if (birthMonth == 5 && (21<=birthDay && birthDay <=31) || birthMonth == 6 && (1<=birthDay && birthDay <=21)) {
        JFrame frame = new JFrame();
        String symbol = "Your sign is Gemini. You are cerebral, chatty, love learning and education, charming, and adventurous.   ";
        symbol += bday;
        JLabel label = new JLabel(symbol, new ImageIcon("gemini.jpg"), JLabel.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }