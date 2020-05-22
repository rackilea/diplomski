//Creating XYseries based on an array (i.e., pt.delayedy)

XYSeriesCollection lineChartDataAD = new XYSeriesCollection();
XYSeries seriesAD = new XYSeries("Real Surface Heights", false, true);

for (int m = 0; m < pt.delayedy.length - 1; m++) {            
    seriesAD.add((double)pt.delayedy[m], (double)pt.delayedy[m+1]);
}

lineChartDataAD.addSeries(seriesAD);

//Customizing my axis labels (required for my purpose)

if (jRadioButton10.isSelected()) {
   pt.xaxisAD = pt.yvar+" ("+pt.xvar+") ["+pt.yunit+"]";
   pt.yaxisADsupport = String.format("%f", (pt.xspace*pt.delay));            
   pt.yaxisAD = pt.yvar+" ("+pt.xvar+"+d) ["+pt.yunit+"]";      
}
else if (jRadioButton11.isSelected()) {            
   pt.xaxisAD = pt.yvar+" (i) ["+pt.yunit+"]";
   pt.yaxisAD = pt.yvar +" (i+d) ["+pt.yunit+"]";
   jLabel44.setText("(Delay (d) = "+pt.delay+")");
}

//Creating a JFreechart with my labels and series

JFreeChart lineChartAD = ChartFactory.createXYLineChart("", pt.xaxisAD, pt.yaxisAD, (XYDataset) lineChartDataAD, PlotOrientation.VERTICAL, false, false, false);

//Getting the chart plot

XYPlot plotAD  = lineChartAD.getXYPlot();

//Creating the renderer for the chart

XYLineAndShapeRenderer rendererAD = new XYLineAndShapeRenderer();
rendererAD.setSeriesPaint(0, Color.BLACK);
double sizeAD = 0;
double deltaAD = sizeAD / 2.0;
Shape shapeAD = new Rectangle2D.Double(-deltaAD, -deltaAD, sizeAD, sizeAD);
rendererAD.setSeriesShape(0, shapeAD);
rendererAD.setSeriesStroke(0, new BasicStroke(1.0f));

//Customizing the font of the axes labels

Font F1AD = new Font ("Times New Roman", Font.PLAIN, 14);        
plotAD.getDomainAxis().setLabelFont(F1AD);
plotAD.getRangeAxis().setLabelFont(F1AD);

//The below lines are for exact same x-scaling and y-scaling in plot

NumberAxis D = (NumberAxis) plotAD.getDomainAxis();
NumberAxis R = (NumberAxis) plotAD.getRangeAxis();
D.setAutoRangeIncludesZero(false);
R.setAutoRangeIncludesZero(false);
Double DT = (D.getUpperBound() - D.getLowerBound())/5;
DecimalFormat DF = new DecimalFormat("#.#");
DF.setRoundingMode(RoundingMode.FLOOR);
String DTS = DF.format(DT);
DT = Double.parseDouble(DTS);
D.setTickUnit(new NumberTickUnit(DT));
Double RT = (R.getUpperBound() - R.getLowerBound())/5;
String RTS = DF.format(RT);
RT = Double.parseDouble(RTS);
R.setTickUnit(new NumberTickUnit(RT));

//Plot customization

plotAD.setOutlinePaint(Color.BLACK);
plotAD.setOutlineStroke(new BasicStroke(0.5f));
plotAD.setRenderer(rendererAD);
plotAD.setBackgroundPaint(Color.WHITE);
plotAD.setRangeGridlinesVisible(true);
plotAD.setRangeGridlinePaint(Color.GRAY);
plotAD.setDomainGridlinesVisible(true);
plotAD.setDomainGridlinePaint(Color.GRAY);

//Creating ChartPanel

ChartPanel linePanelAD = new ChartPanel(lineChartAD, true, true, false, false, true);
linePanelAD.setMouseZoomable(false);

//Adding the ChartPanel to the JPanel 

panelChartRMA4D.removeAll();
panelChartRMA4D.add(linePanelAD, BorderLayout.CENTER);
panelChartRMA4D.setVisible(true);
panelChartRMA4D.setBorder(new LineBorder (Color.BLACK));
panelChartRMA4D.validate();