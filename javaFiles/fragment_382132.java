PDPageLabels pageLabels = document.getDocumentCatalog().getPageLabels();
String[] labels = pageLabels.getLabelsByPageIndices();
for (int i = 0; i < labels.length; ++i)
{
    if ("1".equals(labels[i]))
    {
        System.out.println("found: " + i);
        break;
    }
}