XYPlot plot = (XYPlot) result.getPlot();
        ValueAxis domainAxis = plot.getDomainAxis();
        domainAxis.setAutoRange(true);
        domainAxis.setFixedAutoRange(60000.0);  
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setAutoRange(true);