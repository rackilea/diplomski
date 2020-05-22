public class GoogleDistance {
    public static void main(String[] args) throws InterruptedException, ApiException, IOException {
        new GoogleDistance().go();
    }

    void go() throws InterruptedException, ApiException, IOException {
        String API_KEY = "AIzy...";
        GeoApiContext.Builder builder = new GeoApiContext.Builder();
        builder.apiKey(API_KEY);

        GeoApiContext geoApiContext = builder.build();
        DistanceMatrix results1 = DistanceMatrixApi.getDistanceMatrix(geoApiContext,
                new String[]{"los angeles"}, new String[]{"san francisco"}).units(Unit.METRIC).await();


        DistanceMatrixRow[] rows = results1.rows;
        for (DistanceMatrixRow row : rows) {
            DistanceMatrixElement[] elements = row.elements;
            for (DistanceMatrixElement element : elements) {
                Distance distance = element.distance;
                if(distance == null){
                    System.out.println("distance is null");
                    continue;
                }
                String dist = distance.humanReadable;
                String dur = element.duration.humanReadable;
                System.out.println(dist);
                System.out.println(dur);
            }
        }

    }
}