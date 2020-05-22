public class PojoTransferable implements Transferable {

    public static final DataFlavor POJO_LIST_DATA_FLAVOR = new DataFlavor(List.class, "application/x-java-pojo-list;class=java.util.List");
    public static final DataFlavor HTML_DATA_FLAVOR = new DataFlavor("text/html", "HTML");
    public static final DataFlavor CSV_DATA_FLAVOR = new DataFlavor("text/csv", "CVS");
    public static final DataFlavor PLAIN_DATA_FLAVOR = new DataFlavor("text/plain", "Plain text");
    public static final DataFlavor SERIALIZED_DATA_FLAVOR = new DataFlavor(Pojo.class, "application/x-java-serialized-object; Pojo");

    private static String[] HEADERS = new String[]{"name", "name1", "name2", "name3", "name4"};
    private static Pojo POJO_HEADER = new Pojo("name", "name1", "name2", "name3", "name4");

    private List<Pojo> pojos;

    public PojoTransferable(List<Pojo> pojos) {
        this.pojos = pojos;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{POJO_LIST_DATA_FLAVOR, HTML_DATA_FLAVOR, CSV_DATA_FLAVOR, SERIALIZED_DATA_FLAVOR, PLAIN_DATA_FLAVOR};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        boolean supported = false;
        for (DataFlavor mine : getTransferDataFlavors()) {
            if (mine.equals(flavor)) {
                supported = true;
                break;
            }
        }
        return supported;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        Object data = null;
        if (POJO_LIST_DATA_FLAVOR.equals(flavor)) {
            data = pojos;
        } else if (HTML_DATA_FLAVOR.equals(flavor)) {
            data = new ByteArrayInputStream(formatAsHTML().getBytes());
        } else if (SERIALIZED_DATA_FLAVOR.equals(flavor)) {
            data = pojos;
        } else if (CSV_DATA_FLAVOR.equals(flavor)) {
            data = new ByteArrayInputStream(formatAsCVS().getBytes());
        } else if (PLAIN_DATA_FLAVOR.equals(flavor)) {
            data = new ByteArrayInputStream(formatAsPlainText().getBytes());
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
        return data;
    }

    protected String formatAsCVS(Pojo pojo) {
        StringJoiner sj = new StringJoiner(",");
        sj.add(pojo.getName());
        sj.add(pojo.getName2());
        sj.add(pojo.getName3());
        sj.add(pojo.getName4());
        return sj.toString();
    }

    public String formatAsCVS() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(formatAsCVS(POJO_HEADER));
        for (Pojo pojo : pojos) {
            sb.append(formatAsCVS(pojo));
        }
        return "";
    }

    protected Map<Integer, Integer> columnWidthsFor(Pojo pojo) {
        Map<Integer, Integer> columnWidths = new HashMap<>();
        columnWidths.put(0, pojo.getName().length());
        columnWidths.put(1, pojo.getName1().length());
        columnWidths.put(2, pojo.getName2().length());
        columnWidths.put(3, pojo.getName3().length());
        columnWidths.put(4, pojo.getName4().length());
        return columnWidths;
    }

    protected void apply(Map<Integer, Integer> pojoWidths, Map<Integer, Integer> columnWidths) {
        for (int index = 0; index < 5; index++) {
            int currentWidth = 2;
            if (columnWidths.containsKey(index)) {
                currentWidth = columnWidths.get(index);
            }
            int columnWidth = 2;
            if (pojoWidths.containsKey(index)) {
                columnWidth = pojoWidths.get(index);
            }
            columnWidths.put(index, Math.max(currentWidth, columnWidth));
        }
    }

    protected String formatAsPlainText(Pojo pojo, String format) {
        return String.format(format, pojo.getName(), pojo.getName1(), pojo.getName2(), pojo.getName3(), pojo.getName4());
    }

    public static String fill(int padding) {
        return String.format("%" + padding + "s", "").replace(" ", "-");
    }

    public String formatAsPlainText() {
        Map<Integer, Integer> columnWidths = new HashMap<>();

        apply(columnWidthsFor(POJO_HEADER), columnWidths);
        for (Pojo pojo : pojos) {
            apply(columnWidthsFor(pojo), columnWidths);
        }

        StringJoiner sjFormat = new StringJoiner("|");
        StringJoiner sjSep = new StringJoiner("+");
        for (int index = 0; index < 5; index++) {
            int currentWidth = 0;
            if (columnWidths.containsKey(index)) {
                currentWidth = columnWidths.get(index);
            }
            sjFormat.add(" %-" + currentWidth + "s ");
            sjSep.add(fill(currentWidth + 2));
        }
        sjFormat.add("%n");
        sjSep.add("\n");

        String seperator = sjSep.toString();
        String format = sjFormat.toString();
        StringBuilder sb = new StringBuilder(128);
        sb.append(formatAsPlainText(POJO_HEADER, format));
        for (Pojo pojo : pojos) {
            sb.append(seperator);
            sb.append(formatAsPlainText(pojo, format));
        }
        return sb.toString();
    }

    public String formatAsHTML() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("<html><body>");
        sb.append("<table border='1'>");
        sb.append("<tr>");
        for (String header : HEADERS) {
            sb.append("<th>").append(header).append("</th>");
        }
        sb.append("</tr>");
        for (Pojo pojo : pojos) {
            sb.append("<tr>");
            sb.append("<td>").append(pojo.getName()).append("</td>");
            sb.append("<td>").append(pojo.getName1()).append("</td>");
            sb.append("<td>").append(pojo.getName2()).append("</td>");
            sb.append("<td>").append(pojo.getName3()).append("</td>");
            sb.append("<td>").append(pojo.getName4()).append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");

        return sb.toString();
    }
}