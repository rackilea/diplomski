String resp = "USER: 0xbb492894B403BF08e9181e42B07f76814b10FEdc\n" + "IP: 10.0.2.6\n" + "NETMASK: 255.255.0.0\n"
        + "SUPERNODE: tlcsupernode.ddns.net\n" + "PORT: 5000\n" + "COMMUNITY: tlcnet\n" + "PSK: mysecret\n"
        + "MAC: 00:02:ff:00:02:06";
Map<String, String> map = new HashMap<>();

for (String line : resp.split("\\R")) {
    String[] keyValue = line.split(":", 2);
    map.put(keyValue[0], keyValue[1]);
}

for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(String.format("Key: %s, Value: %s", entry.getKey(), entry.getValue()));
}