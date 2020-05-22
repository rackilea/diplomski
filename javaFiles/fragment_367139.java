public void updatePartControl() {
    Thread thread = new CountdownThread(model, this, displayPanel);
    thread.start();

    frame.remove(alarmPanel.getPanel());
    frame.add(displayPanel.getPanel());
    frame.validate();
    frame.pack();
    frame.setBounds(getBounds());
}