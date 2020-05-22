public ResponseEntity<?> getImage(HttpServletResponse resp) {
    try {
        byte[] img = // your image
        return ReponseEntity.ok(img);
    } catch (Exception e) {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}