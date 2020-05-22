abstract class Property {

    abstract Map<String, String> getPropertyNames();

    abstract void mapProperties(Map<String, String> userInput);

}

class Ip extends Property {

    private String ip;
    private String port;

    public String getIp() {
        return this.ip;
    }

    public int getPort() {
        return Integer.parseInt(this.port);
    }

    Map<String, String> getPropertyNames() {
        Map<String, String> names = new HashMap<>();
        names.put("ip", "IP Address");
        names.put("port", "Port");
    }

    void mapProperties(Map<String, String> userInput) {
        for (Map.Entry<String, String> entry : userInput.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if ("ip".equals(key)) {
                this.ip = value;
            } else if ("port".equals(key)) {
                this.port = value;
            }
        }
    }
}