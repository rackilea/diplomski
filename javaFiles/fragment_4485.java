while (true){
    j.setText("Current Mouse Location: " + m.printLocation());
    c.setText(String.valueOf(m.getMouseColor()));

    // waiting a few milliseconds
    Thread.sleep(200);
}