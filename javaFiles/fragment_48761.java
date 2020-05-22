PostscriptTerminal eps = new PostscriptTerminal("output.eps");

    PlotStyle myPlotStyle = new PlotStyle();
    myPlotStyle.setStyle(Style.POINTS);
    myPlotStyle.setPointType(7); // 7 - circle
    myPlotStyle.setLineType(3); // blue color

    JavaPlot p = new JavaPlot();
    p.setPersist(false);
    p.setTerminal(eps);
    p.getAxis("x").setLabel("X axis", "Arial", 15);
    p.getAxis("y").setLabel("Y axis","Arial", 15);
    p.setKey(JavaPlot.Key.TOP_RIGHT);

    double[][] front = this.writeObjectivesToMatrix();
    DataSetPlot s = new DataSetPlot(front);
    s.setPlotStyle(myPlotStyle);
    s.setTitle("");
    p.addPlot(s);
    p.plot();