private static CategoryDataset createDataset() {
  String series1 = "First";
  String series2 = "Second";
  String series3 = "Third";

  String category1 = "Category 1";
  String category2 = "Category 2";
  String category3 = "Category 3";
  String category4 = "Category 4";
  String category5 = "Category 5";

  DefaultCategoryDataset dataset = new DefaultCategoryDataset();

  dataset.addValue(1.0D, series1, category1);
  dataset.addValue(4.0D, series1, category2);
  dataset.addValue(3.0D, series1, category3);
  dataset.addValue(5.0D, series1, category4);
  dataset.addValue(5.0D, series1, category5);

  dataset.addValue(5.0D, series2, category1);
  dataset.addValue(7.0D, series2, category2);
  dataset.addValue(6.0D, series2, category3);
  dataset.addValue(8.0D, series2, category4);
  dataset.addValue(4.0D, series2, category5);

  dataset.addValue(4.0D, series3, category1);
  dataset.addValue(3.0D, series3, category2);
  dataset.addValue(2.0D, series3, category3);
  dataset.addValue(3.0D, series3, category4);
  dataset.addValue(6.0D, series3, category5);

  return dataset;
}