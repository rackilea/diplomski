public class TOCEvent extends PdfPageEventHelper {

    protected int counter = 0;
    protected List<SimpleEntry<String, SimpleEntry<String, Integer>>> toc = new ArrayList<>();

    @Override
    public void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text) {
        String name = "dest" + (counter++);
        int page = writer.getPageNumber();
        toc.add(new SimpleEntry<String, SimpleEntry<String, Integer>>(text, new SimpleEntry<String, Integer>(name, page)));
        writer.addNamedDestination(name, page, new PdfDestination(PdfDestination.FITH, rect.getTop()));
    }

    public List<SimpleEntry<String, SimpleEntry<String, Integer>>> getTOC() {
        return toc;
    }
}