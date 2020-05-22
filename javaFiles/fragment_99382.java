public class CarProvider {
    // should perhaps consider List<Car> instead of Car[] here ...
    public Cars[] getCars(String carId, String carname) {
        HttpResponse<Car{}> response = Unirest.get(endpointUrl)
          .header("Accept", MediaType.APPLICATION_JSON)
          .queryString("carId",cardId)
          .queryString("carname",carname);

        return deserialise(response.getBody());
    }

    private Car[] deserialise(ResponseBody body) {
        // read the body and deserialise to Car[] 
    }
}