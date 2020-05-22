String ipAddress = "xxx.xxx.xxx.xxx"; // your intend source IP
byte ip[] = InetAddress.getByName(ipAddress).getAddress();
RequestConfig config = RequestConfig.custom()
    .setLocalAddress(InetAddress.getByAddress(ip))
    .build();
HttpClient client = HttpClientBuilder.create().build();
HttpGet getResquest = new HttpGet(address);
getResquest.setConfig(config);
HttpResponse response = client.execute(getResquest);