private static InetAddress[] datapoints;

@BeforeClass
public static void generateData() throws UnknownHostException {
  // do all the work of generating the datapoints
  datapoints = new InetAddress[] {
    InetAddress.getByName("not a valid internet address")
  };
}

@DataPoints
public static InetAddress[] data() {
  return datapoints;
}