// request
final IcmpPingRequest request = IcmpPingUtil.createIcmpPingRequest ();
request.setHost ("192.168.0.101");

// repeat a few times
for (int count = 1; count <= 4; count ++) {

// delegate
final IcmpPingResponse response = IcmpPingUtil.executePingRequest (request);

// log
final String formattedResponse = IcmpPingUtil.formatResponse (response);
System.out.println (formattedResponse);

// rest
Thread.sleep (1000);
}