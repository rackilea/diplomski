//List<Series<Double, Double>> myOrderedListOfSeries;

myOrderedListOfSeries.forEach(series->
    series.getData().forEach(dataPoint->
         dataPoint.getNode().toFront()
     )
 );