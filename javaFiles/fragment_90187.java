public class Report {
    private Set<CallLog> calls = // initialized somehow...

    public void printByName() {
        calls.stream()
             .sorted(Comparator.comparing(CallLog::logName))
             .forEach(System.out::println);
}