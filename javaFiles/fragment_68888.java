String netLink = "http://checkdnd.com/api/check_dnd_no_api.php?mobiles=9999999999";
String protocol = isHttpOrHttps(netLink);
String netLinkProtocol = netLink.substring(0, netLink.indexOf(":"));
if (!netLinkProtocol.equals(protocol)) {
    netLink = protocol + netLink.substring(netLink.indexOf(":"));
}
List<String> list = getWebPageSource(netLink);
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}