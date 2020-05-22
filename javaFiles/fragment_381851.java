int[] listObjA = {312,23,241};

GridPane gridpane = new GridPane();

gridpane.add(new Label("Item Listing"), 0, 0);

for (int i = 0 ; i < listObjA.length; i++) {
    Label label = new Label(Integer.toString(listObjA[i]));
    gridpane.add(label, i+1, 0);
}