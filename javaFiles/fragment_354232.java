public class UdpData {
private String name;
private String address;
private int port;
public UdpData(String name, String address, int port) {
    super();
    this.name = name;
    this.address = address;
    this.port = port;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}
public int getPort() {
    return port;
}
public void setPort(int port) {
    this.port = port;
}
}