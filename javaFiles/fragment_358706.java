public static void main(String[] args)
{
    try
    {
        String template = Common.DATA_DIR + "Contact Template.docx";
        String saveDocument = Common.DATA_DIR + "Contact with tables.docx";
        String bookmarkNameContact = "ContactEnd";

        // Load the template
        com.aspose.words.Document wordDoc = new com.aspose.words.Document(template);
        DocumentBuilder builder = new DocumentBuilder(wordDoc);

        // Find the contacts bookmark
        com.aspose.words.Bookmark bookmarkContact = wordDoc.getRange().getBookmarks().get(bookmarkNameContact);

        // Set the table with null
        com.aspose.words.Table table = null;

        // Add some rows
        for (int i = 0; i < 50; i++)
        {
            // If contacts bookmark is on 1st page, add new rows to first table
            if (getBookmarkPage(wordDoc, bookmarkContact) == 1)
            {
                table = (com.aspose.words.Table) wordDoc.getChild(NodeType.TABLE, 0, true);
            } else
            {
                // If the contacts bookmark is on second page, add rows to second table
                table = (com.aspose.words.Table) wordDoc.getChild(NodeType.TABLE, 1, true);
                // If there is no second table, create it
                if (table == null)
                {
                    table = createNewTable(wordDoc, bookmarkContact);
                }
            }

            // Add rows dynamically to either first or second table
            addRow(wordDoc, table, "some text " + i);
        }

        // Save the document
        wordDoc.save(saveDocument);

    } catch (Exception ex)
    {
        System.err.println(ex.getMessage());
    }
}

private static com.aspose.words.Table createNewTable(com.aspose.words.Document wordDoc, com.aspose.words.Bookmark bookmarkContact) throws Exception
{
    // Get the first table and clone it to create the second one
    com.aspose.words.Table firstTable = (com.aspose.words.Table) wordDoc.getChild(NodeType.TABLE, 0, true);
    com.aspose.words.Table table = (com.aspose.words.Table) firstTable.deepClone(true);

    // Add the second table after the bookmark
    bookmarkContact.getBookmarkEnd().getParentNode().getParentNode().appendChild(table);

    // Delete all its rows
    table.getRows().clear();

    return table;
}

// Add a new row to the table
private static void addRow(com.aspose.words.Document wordDoc, com.aspose.words.Table table, String text)
{
    // Create a new row
    com.aspose.words.Row row = new com.aspose.words.Row(wordDoc);
    row.getRowFormat().setAllowBreakAcrossPages(true);
    // Add it to the table
    table.appendChild(row);
    // Add cells to the row
    for (int iCell = 0; iCell < 4; iCell++)
    {
        // Create a new cell and set text inside it
        com.aspose.words.Cell cell = new com.aspose.words.Cell(wordDoc);
        cell.appendChild(new com.aspose.words.Paragraph(wordDoc));
        cell.getFirstParagraph().appendChild(new Run(wordDoc, text));
        cell.getFirstParagraph().getParagraphFormat().setSpaceAfter(0);

        row.appendChild(cell);
    }
}

private static int getBookmarkPage(com.aspose.words.Document wordDoc, com.aspose.words.Bookmark bookmarkContact) throws Exception
{
    // Find the page number, where our contacts bookmark is
    LayoutCollector collector = new LayoutCollector(wordDoc);
    return collector.getStartPageIndex(bookmarkContact.getBookmarkEnd());
}