public Chart(){
   super(FXCollections.observableArrayList(
         new PieChart.Data("Fruits", 75),
         new PieChart.Data("Vegetables", 25)
   ));
}