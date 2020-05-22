private void openAnexo() {
    javax.swing.Timer timer = new javax.swing.Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int width = pnl.getWidth();
            if(width > 200) {
                ((javax.swing.Timer)e.getSource()).stop();
            } else {
                pnl.setPreferredSize(new Dimension(width + 1, 300));
                Calculadora.this.pack();
            }

        }
    });
    timer.setRepeats(true);
    timer.setDelay(200);
    timer.start();
}