new Reader file.xml
while not at the end of file.xml {
    String node = read_first_main_document_node();
    InputStream is = new ByteArrayInputStream( node.getBytes( charset ) );
    parse(is); 
}