public void refreshCategoryModel() {
    createCategoryModel();
}

private void createCategoryModel() {  
    categoryModel = new CartesianChartModel();  

    birthsSeries = new ChartSeries();
    birthsSeries.setLabel("Рождения");

    birthsSeries.set(2012, 0);
    categoryModel.addSeries(birthsSeries);
}