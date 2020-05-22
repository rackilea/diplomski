popDownButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent event) {
       whatToSearch.setSelectedIndex(elementsToSearch.getSize() - 1);
       whatToSearch.ensureIndexIsVisible(elementsToSearch.getSize() - 1);   
    }
});