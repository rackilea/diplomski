@Override
      public void setup(Context context)

      {
        Configuration conf = context.getConfiguration();

        try {

          cachefiles = DistributedCache.getLocalCacheFiles(conf);

          File database = new File(cachefiles[0].toString()); //

          reader = new DatabaseReader.Builder(database).build();

        } catch (IOException e) {
          e.printStackTrace();
        }

      }
public void map(Object key, Text line, Context context) throws IOException,
      InterruptedException {

                     .....

InetAddress ipAddress = InetAddress.getByName(address.getHostAddress());
      CityResponse response = null;
      try {
        response = reader.city(ipAddress);
      } catch (GeoIp2Exception ex) {
        ex.printStackTrace();
        return;
      }
                     ......