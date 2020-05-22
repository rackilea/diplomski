// RoomListener, not roomListener
class RoomListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        AbstractButton btn = (AbstractButton) event.getSource();
        btn.setText("Adding bed..);
        addBedGui(); //Generic window for adding bed info.
    }
}