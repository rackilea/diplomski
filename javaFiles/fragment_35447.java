public class CountryVsCountryChart extends JPanel
{
    private static final long serialVersionUID = 1L;
    private ArrayList<Player> players;
    private StatUtilities stats;

    public CountryVsCountryChart(String applicationTitle, String chartTitle, ArrayList<Player> players, int option) {
        //super(applicationTitle);

        this.players = players;
        stats = new StatUtilities();

        // This will create the dataset 
        PieDataset dataset = createDataset(option);
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);

        // Don't forget me...
        setLayout(new BorderLayout());
        add(chartPanel); 
}