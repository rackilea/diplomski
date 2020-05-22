Timer timer = new Timer(speed, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       /* Code to perform one step of Prim's algorithm here */
       /* Change edge/vertex colour for step */
       /* Call timer.stop(), once done */

       GraphPanel.this.repaint();
    }
});
timer.setRepeats(true);
timer.setDelay(3000);
timer.start();