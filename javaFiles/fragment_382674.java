jCheckBox1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent evt) {
       agreed = jCheckBox1.isSelected();
       updateState();
   }
});
//...
ActionListener taskPerformer = new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        timeLeftFinished = true;
        updateState();
    }
};
Timer timer = new Timer(0, taskPerformer);
//...

protected void updateState() {
    jButton3.setEnabled(timeLeftFinished && agreed);
}