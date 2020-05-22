Promise<String> promise = WS.url("http://myposttarget.com")
 .setContentType("application/x-www-form-urlencoded")
 .post("key1=value1&key2=value2")
 .map(
    new Function<WSResponse, String>() {
        public String apply(WSResponse response) {
            String result = response.getBody();
            return result;
        }
    }
);