licz.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        info.setText("Loading...");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                boolean good = false;
                if (go())
                {   
                    brute(0);
                    good = odwrot;
                }
                JOptionPane.showMessageDialog(frame, good ? "good" : "bad");
                info.setText("Done");
            }
        });
    }
});