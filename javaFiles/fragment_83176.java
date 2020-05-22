cancelBtn.addActionListener(new ActionListener() {  // This creates a new class implementing ActionListener
    public void actionPerformed(ActionEvent e) {

        ItemPanelEvent ev = new ItemPanelEvent(this);    // Here is the problem

        if (itemPanelListener != null) {
            itemPanelListener.itemPanelEventOccurred(ev);
        }

    }
});