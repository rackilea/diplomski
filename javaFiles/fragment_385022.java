public class MyPatternLayout extends PatternLayout {

    private List<String> test = new ArrayList<>();

    public void addTest(String test) {
        this.test.add(test);
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        return test.stream().collect(Collectors.joining(", ")); //temporary, for testing purposes only
    }
}