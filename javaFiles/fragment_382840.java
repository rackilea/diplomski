@Override
public void actionPerformed(ActionEvent e) {
    if ("Fetch".equals(e.getActionCommand())) {
        Platform.runLater(new Runnable() { 
            @Override
            public void run() {
                TXTarea.append("Fetching coordinates data... \n");
                … 
            }
        });
    }
    …
}