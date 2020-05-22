HttpResponse<JsonNode> response = null;

try {
    response = Unirest.get("https://www.ncdc.noaa.gov/cdo-web/api/v2/datatypes")
            .header("token", "YOUR_TOKEN_HERE")
            .asJson();
} catch (UnirestException e) {
    //Uh oh!
    e.printStackTrace();
}

System.out.println(response.getBody());