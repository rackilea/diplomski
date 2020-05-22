public class Main {

    public static void main(String[] args) {
        Map<String, Integer> request = new HashMap<String, Integer>();
        request.put("price", 5);
        request.put("gender", 1);

        List<Calculator> calculators = new ArrayList<Calculator>();
        calculators.add(new Calculator1());
        calculators.add(new Calculator2());

        Collections.sort(calculators, new CalcComparator(request));

        System.out.println("For request: "+request);
        for (Calculator c : calculators) {
            System.out.println("\t"+c.toString() + "( fitness " + c.fitnessFor(request) + ")");
        }
    }
}