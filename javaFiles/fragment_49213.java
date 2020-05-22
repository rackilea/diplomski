load.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        displayedPositionIndex++;
        if(displayedPositionIndex >= obj.size()) {
            displayedPositionIndex = 0; // to loop back to first after last position
        }
        setPosition(displayedPositionIndex);
    }
});