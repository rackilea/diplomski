boolean found = false;
for (int i = 0; i < myList.size() && !found; i++) {
    if (packet.getAddress().equals(InetAddress.getByName(myList.get(i)))) {
        found = true;
        System.out.println("this packet's IP address is in list");
    }
}
if (!found) {
    System.out.println("this packet's IP address is not in list!");
}