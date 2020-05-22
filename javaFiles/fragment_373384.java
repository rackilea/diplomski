addItem.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        ...
        // add item in the list.
        ...
        for (int i = 0; i < displayedItems.size(); i++) {
            addLowerPane.add(displayedItems.get(i).getComponent());
            validate();
            repaint();
        }

    }
});