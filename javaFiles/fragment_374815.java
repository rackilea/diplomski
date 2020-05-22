private XYDataset createDataset(int[] epochNo, int[] bFacts) {
    final XYSeries myline = new XYSeries( "myline" );          
    for (int i = 0; i < epochNo.length; i++) {
        myline.add(epochNo[i], bFacts[i]);
    }      
    final XYSeriesCollection dataset = new XYSeriesCollection( );          
    dataset.addSeries(myline);          
    return dataset;
}