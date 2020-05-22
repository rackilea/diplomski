public class GoogleDistance {
    public static void main(String[] args) throws InterruptedException, ApiException, IOException {
        new GoogleDistance().go();
    }

    void go() throws InterruptedException, ApiException, IOException {
        String API_KEY = "AIzy....";
        GeoApiContext.Builder builder = new GeoApiContext.Builder();
        builder.apiKey(API_KEY);

        GeoApiContext geoApiContext = builder.build();
        DistanceMatrix results1 = DistanceMatrixApi.getDistanceMatrix(geoApiContext,
                new String[]{"rose hill"}, new String[]{"port louis"}).units(Unit.METRIC).await();
        System.out.println(Arrays.toString(results1.destinationAddresses));
    }
}