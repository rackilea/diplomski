private ArrayList<String> ips = new ArrayList<String>();

for (String site : sites) {
try {
    address = InetAddress.getByName(new URL(site).getHost());
} catch (Exception e) {
    System.out.println(e);
}
String ip = address.getHostAddress();
ips.add(ip);

}