private class ItemHandler implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent event) {
        try {
            if(event.getSource() == choice_GuitarBrand) {
                /*I have a guitar array that will fetch the associated ID of the selected
                item given the name */
                int id = cmd.fetchGuitarID(choice_GuitarBrand.getSelectedItem());
                choice_TypeOfGuitar.removeAll(); // see https://docs.oracle.com/javase/7/docs/api/java/awt/Choice.html#removeAll()
                for(Guitar g : cmd.getSpecificGuitar(id)) {
                    choice_TypeOfGuitar.add(g.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}