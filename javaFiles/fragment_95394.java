public Chart(){
    ObservableList<PieChart.Data>pieChart = FXCollections.observableArrayList(
            new PieChart.Data("Fruits", 75),
            new PieChart.Data("Vegetables", 25)
            );
    setData(pieChart);
    // no need for this -> PieChart chart = new PieChart(pieChart);
}