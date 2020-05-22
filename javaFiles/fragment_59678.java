licz.addActionListener((e) -> {
    info.setText("Loading...");
    EventQueue.invokeLater(() -> {
        boolean good = false;
        if (go())
        {   
            brute(0);
            good = odwrot;
        }
        JOptionPane.showMessageDialog(frame, good ? "good" : "bad");
        info.setText("Done");
    });
});