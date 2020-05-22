ObjectMapper mapper = new ObjectMapper();
mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

Tweet tweet = mapper.readValue(br, Tweet.class);

System.out.println(tweet.getUser().get("id"));