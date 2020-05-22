JasperDesign design = xmlLoader.loadXML(..jrxmlStream..);
JRElement[] elements = design.getDetail().getElements();
String elementKey = ..key of element to modify..;
int newWidth = ..new element width..;
for (int i = 0; i < elements.length; i++)
{
    JRDesignElement element = (JRDesignElement) elements[i];
    if (elementKey.equals(element.getKey())) {
        element.setWidth(newWidth);
    }
}