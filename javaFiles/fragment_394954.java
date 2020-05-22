button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        // vp = new MyPanel();
        // vp.revalidate();
        mp.remove(vp);  // remove the original MyPanel from the GUI
        vp = new MyPanel();  // create a new one
        mp.add(vp, BorderLayout.CENTER); // add it to the container

        // ask the container to layout and display the new component 
        mp.revalidate();
        mp.repaint();
    }
});