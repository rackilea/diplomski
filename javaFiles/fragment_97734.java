@Test
public void testVariables() throws IOException
{
    try (   InputStream resource = getClass().getResourceAsStream("Variables.pdf");
            PDDocument document = PDDocument.load(resource);    )
    {
        System.out.println("\nVariables.pdf\n-------------\n");
        printSubwords(document, "${var1}");
        printSubwords(document, "${var 2}");
    }
}