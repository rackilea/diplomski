public static DocumentFragment parseXml(Document doc, String fragment)
 {
    // Wrap the fragment in an arbitrary element.
    fragment = "<fragment>"+fragment+"</fragment>";
    try
    {
        // Create a DOM builder and parse the fragment.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document d = factory.newDocumentBuilder().parse(
                new InputSource(new StringReader(fragment)));

        // Import the nodes of the new document into doc so that they
        // will be compatible with doc.
        Node node = doc.importNode(d.getDocumentElement(), true);

        // Create the document fragment node to hold the new nodes.
        DocumentFragment docfrag = doc.createDocumentFragment();

        // Move the nodes into the fragment.
        while (node.hasChildNodes())
        {
            docfrag.appendChild(node.removeChild(node.getFirstChild()));
        }
        // Return the fragment.
        return docfrag;
    }
    catch (SAXException e)
    {
        // A parsing error occurred; the XML input is not valid.
    }
    catch (ParserConfigurationException e)
    {
    }
    catch (IOException e)
    {
    }
    return null;
}