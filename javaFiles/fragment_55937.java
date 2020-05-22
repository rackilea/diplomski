public class EntityDetailsListener implements ActionListener{
    private EntityDetails entityView;
    private Map mapView;
    @Override
    public void actionPerformed(ActionEvent e){
        //Doing some things
        if (e.getSource() == changeNameButton){
            //For exemple, if you change the name of the entity on the EntityDetails view.
            mapView.updateEntity(this); //calling the update method in the Map class.
        }
    }
}