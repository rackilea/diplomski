public class Demo {

    public static void main(String arg[]) throws IOException {

        DefaultCategoryDataset result = new DefaultCategoryDataset();
        result.addValue(20.3, "Apraisal Forms", "Dtest");
        result.addValue(19.4, "Resignation  Form", "Dtest");
        result.addValue(16.5, "HES forms", "Dtest");
        result.addValue(8, "Feedback forms", "Dtest");

        result.addValue(27.2, "Apraisal Forms", "HR Dept");
        result.addValue(5.9, "Resignation  Form", "HR Dept");
        result.addValue(14.4, "Feedback forms", "HR Dept");
        result.addValue(4, "HES forms", "HR Dept");

        result.addValue(18.4, "Resignation  Form", "Admin Dept");
        result.addValue(16.1, "HES forms", "Admin Dept");
        result.addValue(13.7, "Feedback forms", "Admin Dept");

        JFreeChart chart = ChartFactory.createStackedBarChart3D(
            "overview by Departments", "x label", "Message Count", result,
            PlotOrientation.VERTICAL, true, true, true);

        SubCategoryAxis domainAxis = new SubCategoryAxis("Name of Department");
        domainAxis.setCategoryMargin(0.60);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setDomainAxis(domainAxis);

        String map = "";

        ChartRenderingInfo info = new ChartRenderingInfo(
            new StandardEntityCollection());

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ChartUtilities.writeChartAsPNG(out, chart, 600, 400, info);

            ToolTipTagFragmentGenerator tooltipConstructor = new ToolTipTagFragmentGenerator() {
                public String generateToolTipFragment(String arg0) {
                    String toolTip = " title = \"value" + arg0 + "\"";
                    return (toolTip);
                }
            };

            URLTagFragmentGenerator urlConstructor = new URLTagFragmentGenerator() {
                public String generateURLFragment(String arg0) {
                    String address = " href=\"ControllerAddress\\methodName?"
                        + arg0 + "\"";
                    return (address);
                }
            };

            map = ChartUtilities.getImageMap("chart", info, tooltipConstructor,
                urlConstructor);
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(map);
        ChartFrame frame1 = new ChartFrame("Bar Chart", chart);
        frame1.setVisible(true);
        frame1.setSize(600, 350);
    }
}