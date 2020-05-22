XYSeriesCollection xyDataSet = new XYSeriesCollection();

        JFreeChart chart = ChartFactory.createXYLineChart(
                cur_chart.getTitle(),
                cur_chart.getxLabel(), cur_chart.getyLabel(),
                xyDataSet,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        String chartId = null;
        for ( Object  tt :  chart.getSubtitles()){
            if (tt instanceof TextTitle){
                chartId= ((TextTitle) tt).getText();
            }
        }

        XYPlot plot = chart.getXYPlot();


    //following code to set font size and color is required so that same chart with matching tooltip pixels can we generated. 
        LegendItemCollection legends =  plot.getLegendItems();


        List<JRSeriesColor> colors = new ArrayList<JRSeriesColor>();

        System.out.println("Customizer: "+ chartId);

        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        Color trans = new Color(0xFF, 0xFF, 0xFF, 0);
        chart.setBackgroundPaint(trans);
        plot .setBackgroundPaint(trans);
        chart.getLegend().setBackgroundPaint(trans);

        chart.setTitle(cur_chart.getTitle());

        Font font3 = new Font("Dialog", Font.PLAIN, 10); 
        plot.getDomainAxis().setLabelFont(font3);
        plot.getRangeAxis().setLabelFont(font3);
        plot.getDomainAxis().setLabelPaint(Color.BLACK);
        plot.getRangeAxis().setLabelPaint(Color.BLACK);

    //some more code to add real time data to XyDataset, 


    ToolTipTagFragmentGenerator tooltipConstructor = new ToolTipTagFragmentGenerator() {
            public String generateToolTipFragment(String arg0) {
                String toolTip = " title = \"" + arg0.replace("\"", "") + "\"";
                return (toolTip);
            }
        };

        URLTagFragmentGenerator urlConstructor = new URLTagFragmentGenerator() {
            public String generateURLFragment(String arg0) {
                String address = " href=\"ControllerAddress\\methodName?"
                    + arg0.replace("\"", "") + "\"";
                return (address);
            }
        };



        ChartRenderingInfo info = new ChartRenderingInfo(
                new StandardEntityCollection());
       // BufferedImage bi  chart.createBufferedImage(272, 178, info); 
        TextTitle tt =  new TextTitle("chart1");
        tt.setFont(font3);
        chart.addSubtitle(tt);
        ChartUtilities.saveChartAsPNG(new File("/tmp/test.png"), chart, 500, 250, info);
    String map = ChartUtilities.getImageMap(cur_chart.getName(), info, tooltipConstructor, urlConstructor);