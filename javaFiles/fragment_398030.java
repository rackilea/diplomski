try {

    restTemplate.getForObject("https://api.twitter.com/1.1/followers/ids.json", Object.class);
}
} catch (HttpStatusCodeException e) {

    if (e.getStatusCode() == HttpStatus.BAD_REQUEST) { // Http code 400
            String bodyResponse = e.getResponseBodyAsString();
            ObjectMapper mapper = new ObjectMapper();

            try {
                return mapper.readValue(bodyResponse, Object.class);
            } catch (Exception exception) {
            }

        }