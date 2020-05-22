private Thread controller = new Thread() {
public void run() {

        final Component panel1 = generatePartnerSelectionPanel();

        // First we set the initial pane (for the selection of partner).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.getContentPane().add(panel1);
                frame.invalidate();
                frame.validate();
        }
        });
        // Update the pane for the selection of the parnter.
        for (int i=40; i>0; i=i-1) {
            final int sec = i;
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    timeLeftLabel.setText(sec + " seconds left.");
                }
            });
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
            if (partnerSubmitted) {break;}
        }
        // For the given user the selection phase is finished (either the time is over or form was submitted).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.getContentPane().remove(panel1);
                frame.getContentPane().add(generateWaitForGamePanel());
                frame.invalidate();
                frame.validate();
        }
        });

}
};