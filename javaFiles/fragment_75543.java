public void publish() throws IOException {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime(); 
    XWikiXmlRpcClient rpc = new XWikiXmlRpcClient(CONFLUENCE_URI);
    try {
        rpc.login(USER_NAME, PASSWORD);
        //The info macro would get rendered an info box in the Page
        Page page = new Page();
        page.setSpace("Some space");
        page.setTitle("Testing XML RPC calls in confluence_" + df.format(today));            
        //page.setContent(
        String s = String.format("||Heading 1||Heading 2||Heading 3||%s|col A1|col A2|col A3|", "\r\n");
        page.setContent(s);
        page.setParentId(PAGEID);            
        rpc.storePage(page);
        } catch (XmlRpcException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

            // TODO Auto-generated catch block

}