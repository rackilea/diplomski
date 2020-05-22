//Arraylist made of arraylist containing the data I need
ArrayList<ArrayList<Dice>> roundTrackData = gameManager.roundTrack.getDices();
System.out.println(roundTrackData);
final Map<String, WeakReference<Image>> cache = new HashMap<>();

for(int h = 0; h < roundTrackData.size(); h++) {
    ComboBox<String> combo = listaComboBox.get(h);
    combo.setCellFactory(c -> new StatusListCell(cache));
    ObservableList<String> options = FXCollections.observableArrayList();

    List<Dice> testing = roundTrackData.get(h);
    System.out.println(" Testing:" + testing);
    System.out.println(" Testing size:" + testing.size());

    for(Dice die : testing){
         System.out.println(" Inside cicle ");
         String color = Character.toString(die.getColor());
         String value = die.getValue().toString();
         String diceRound = value+color+".png";

         options.add(diceRound);
         //listaComboBox is an array list containing 10 comboboxes
         System.out.println("Dice color "+ color);
         System.out.println("Dice value"+ value);
    }

    combo.setItems(options);
}