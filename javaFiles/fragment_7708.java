public static void testThis(){
     List <Triple> list = new ArrayList<>();
     GridPane gp = new GridPane();
     Text a1 = new Text("Click here");
     Text a2 = new Text("Click there");
     gp.add(a1, 5, 5);
     gp.add(a2, 5, 5);

     for(int i=0; i<gp.getChildren().size; i++){
           list.add(new Triple(gp.getChildren().get(i),
                GridPane.getRowIndex(gp.getChildren().get(i)), GridPane.getColumnIndex(gp.getChildren().get(i))));
       }

        Text tempText = (Text) getItem (list, 5, 5);
        System.out.println(tempText.getText());