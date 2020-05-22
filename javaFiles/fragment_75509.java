final JButton btnAccept = new JButton("Accept");
btnAceptar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        SwingWorker worker = new SwingWorker<Object, Integer> {
            protected Object doInBackground() {
                for(int i = 0; i <= 40; i++) {
                    try {
                        Thread.sleep(500);
                    } 
                    catch(InterruptedException ex) {
                        break;
                    }
                    publish(i);
                }
            }                

            protected void process(List<Integer> chunks) {
                // Only care about the last update...
                dataset.setValue(chunks.get(chunks.size() - 1));
            }
        }
    }
});
panel.add(btnAceptar);