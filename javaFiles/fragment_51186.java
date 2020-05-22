...
      chart.plot(data);

      chart.getCTChart().getPlotArea().getBarChartArray(0).addNewBarDir().setVal(
       //org.openxmlformats.schemas.drawingml.x2006.chart.STBarDir.COL);
       org.openxmlformats.schemas.drawingml.x2006.chart.STBarDir.BAR);
      chart.getCTChart().getPlotArea().getBarChartArray(0).addNewAxId().setVal(bottomAxis.getId());
      chart.getCTChart().getPlotArea().getBarChartArray(0).addNewAxId().setVal(leftAxis.getId());
...