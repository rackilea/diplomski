NodeList root = document.getChildNodes();
// Keep in mind that you have the following structure:
// result
//   server
//    checks
//     check
//      checkId
//     check
//      checkId

Node resultNode = getNodes("result", root);
Node server = getNodes("server", resultNode.getChildNodes());
Node checks = getNodes("checks", server.getChildNodes());
NodeList childNodes = checks.getChildNodes();
for (int i = 0; i < childNodes.getLength(); i++) {
    Node possibleCheck = childNodes.item(i);
    if (possibleCheck.getNodeName().equals("check")) {
    String checkid = getNodeValue("checkid", possibleCheck.getChildNodes());
    System.out.println(checkid);
    }
}