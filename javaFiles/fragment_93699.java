@RequestMapping(value = "/app/foo-bar")
    public String serveRest(@RequestBody String body, @RequestHeader HttpHeaders headers) {


        List<String> parameters = headers.get("parameters");

        String referer = null;
        for (String header : parameters) {
            if (header.equals("referer")) {
                referer = header;
            }
        }
        System.out.println(referer);

        return referer;
    }