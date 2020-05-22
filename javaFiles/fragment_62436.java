public class Pivot {
    private static final class Data {

        private final String consultedOn;
        private final String consultedBy;

        public Data(String consultedOn, String consultedBy) {
            this.consultedOn = consultedOn;
            this.consultedBy = consultedBy;
        }

        public String getConsultedOn() {
            return consultedOn;
        }

        public String getConsultedBy() {
            return consultedBy;
        }
    }

    private static final class Row {
        private final String consultedOn;
        private final Map<String, Integer> consultationsByPerson = new HashMap<>();

        public Row(String consultedOn) {
            this.consultedOn = consultedOn;
        }

        public void addPerson(String person) {
            consultationsByPerson.merge(person, 1, Integer::sum);
        }

        public int getConsultationsFor(String person) {
            return consultationsByPerson.getOrDefault(person, 0);
        }

        public String getConsultedOn() {
            return consultedOn;
        }
    }

    private static class PivotReport {

        private final Map<String, Row> rowsByConsultedOn = new HashMap<>();
        private SortedSet<String> persons = new TreeSet<>();

        private PivotReport() {}

        private void addData(Data d) {
            rowsByConsultedOn.computeIfAbsent(d.getConsultedOn(), Row::new).addPerson(d.getConsultedBy());
            persons.add(d.consultedBy);
        }

        public static PivotReport create(List<Data> list) {
            PivotReport report = new PivotReport();
            list.forEach(report::addData);
            return report;
        }

        public String toString() {
            String headers = "Consulted on\t" + String.join("\t", persons);
            String rows =  rowsByConsultedOn.values()
                                            .stream()
                                            .sorted(Comparator.comparing(Row::getConsultedOn))
                                            .map(this::rowToString)
                                            .collect(Collectors.joining("\n"));
            return headers + "\n" + rows;
        }

        private String rowToString(Row row) {
            return row.getConsultedOn() + "\t" +
                persons.stream()
                       .map(person -> Integer.toString(row.getConsultationsFor(person)))
                       .collect(Collectors.joining("\t"));
        }
    }


    public static void main(String[] args) {
        List<Data> list = createListOfData();
        PivotReport report = PivotReport.create(list);
        System.out.println(report);
    }

    private static List<Data> createListOfData() {
        List<Data> reports = new ArrayList<Data>();

        reports.add(new Data("04/12/2018","Mr.Bob"));
        reports.add(new Data("04/12/2018","Mr.Jhon"));
        reports.add(new Data("04/12/2018","Mr.Bob"));
        reports.add(new Data("05/12/2018","Mr.Jhon"));
        reports.add(new Data("06/12/2018","Mr.Bob"));
        reports.add(new Data("06/12/2018","Mr.Jhon"));
        reports.add(new Data("07/12/2018","Mr.Bob"));
        reports.add(new Data("07/12/2018","Mr.Smith"));

        return reports;
    }
}