public class Parser {
    private ArrayList<ParsingStep> steps;

    public Parser() {
        steps = new ArrayList<ParsingStep>();
    }

    public void addStep(ParsingStep step) {
        steps.add(step);
    }

    public Map<String,String> parse(String line) {
        String remainingLine = line;

        for (ParsingStep step : steps) {
            remainingLine = step.parse(remainingLine);
        }

        return map; // Somehow convert to map.
    }
}