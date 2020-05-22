private ResponseEntity<String> buildResponse(WebRequest request, HttpStatus status, String message) {
        HttpHeaders httpHeader = new HttpHeaders();
        List<MediaType> acceptHeader =
                MediaType.parseMediaTypes(Arrays.asList(request.getHeaderValues(HttpHeaders.ACCEPT)));

        if (acceptHeader.stream().anyMatch(mediaType -> mediaType.isCompatibleWith(MediaType.APPLICATION_JSON))) {
            httpHeader.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>("{ \"error\": \"" + message + "\" }", httpHeader, status);
        } else if (acceptHeader.stream().anyMatch(mediaType -> mediaType.isCompatibleWith(MediaType.TEXT_PLAIN))) {
            httpHeader.setContentType(MediaType.TEXT_PLAIN);
            return new ResponseEntity<>(message, httpHeader, status);
        } else {
            return ResponseEntity.status(status).body(null);
        }
    }