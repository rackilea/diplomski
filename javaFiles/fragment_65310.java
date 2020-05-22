public class TestList
{

    public static void main(String[] args) throws IOException, DocumentException
    {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("testlist.pdf"));
        document.open();
        List list1 = new List(List.ALPHABETICAL, 20);
        list1.add(new ListItem(new Chunk("Level 1 - Item 1")));
        list1.add(new ListItem(new Chunk("Level 1 - Item 2")));
        list1.add(new ListItem(new Chunk("Level 1 - Item 3")));

        List list2 = new List(List.ORDERED, 20);
        list2.add(new ListItem(new Chunk("Level 2 - Item 1")));
        list2.add(new ListItem(new Chunk("Level 2 - Item 2")));

        List list3 = new List(List.ORDERED, 20);
        list3.add(new ListItem(new Chunk("Level 3 - Item 1")));
        list3.add(new ListItem(new Chunk("Level 3 - Item 2")));
        list3.add(new ListItem(new Chunk("Level 3 - Item 3")));
        list3.add(new ListItem(new Chunk("Level 3 - Item 4")));
        list2.add(list3);

        list2.add(""); // Changed line.
        list1.add(list2);

        list1.add(new ListItem(new Chunk("Level 1 - Item 4")));
        document.add(list1);
        document.newPage();

        ColumnText cols = new ColumnText(writer.getDirectContent());
        cols.setSimpleColumn(36, 36, 549, 806);
        cols.addElement(list1);
        cols.go();

        document.close();
    }
}