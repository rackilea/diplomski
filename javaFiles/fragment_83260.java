public class Main {
    public static void main(String[] args) throws Exception {
        final String html = 
            "<html><head/><body>" +
                "<table id=\"example\">" +
                    "<tr><td>John</td><td>Doe</td></tr>" +
                    "<tr><td>Michael</td><td>Smith</td>" +
                "</table>" +
            "</body></html>";

        final List<Tuple> tuples = parse (html, "example");
                    //... Here the table is parsed
    }

    private static final List<Tuple> parse(final String html, final String tableId) {
        final List<Tuple> tuples = new LinkedList<Tuple> ();

        final Element table = Jsoup.parse (html).getElementById(tableId);
        final Elements rows = table.getElementsByTag("tr");
        for (final Element row : rows) {
            final Elements children = row.children();
            final int childCount = children.size(); 
            final Tuple tuple = new Tuple (childCount);
            for (final Element child : children) {
                tuple.addColumn (child.text ());
            }
        }

        return tuples;
    }
}

public final class Tuple {
    private final String[] columns;

    private int cursor;

    public Tuple (final int size) {
        columns = new String[size];
        cursor = 0;
    }

    public String getColumn (final int no) {
        return columns[no];
    }

    public void addColumn(final String value) {
        columns[cursor++] = value;
    }
}