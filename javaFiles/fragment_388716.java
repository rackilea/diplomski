@Component
public class DemoRunner implements CommandLineRunner
{
    @Autowired
    private List<Metric> allMetrics;

    @Autowired
    @Qualifier(Metrics.HOURS_WORKED)
    private Metric hoursWorkedMetric;

    @Autowired
    @Qualifier(Metrics.MONTHLY_DEALS)
    private Metric monthlyDealsMetric;

    @Autowired
    @Qualifier(Metrics.MONTHLY_GOAL)
    private Metric monthlyGoalMetric;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();

        System.out.println("All metrics:");
        allMetrics.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("HOURS_WORKED metric: " + hoursWorkedMetric);
        System.out.println("MONTHLY_DEALS metric: " + monthlyDealsMetric);
        System.out.println("MONTHLY_GOAL metric: " + monthlyGoalMetric);

        System.out.println();
    }
}