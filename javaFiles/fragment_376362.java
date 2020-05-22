@GetMapping(value = "/image", produces = "image/png")
public ResponseEntity<StreamingResponseBody> image() {
    BufferedImage canvas = service.createImage();

    StreamingResponseBody stream = outputStream ->
            ImageIO.write(canvas, "png", outputStream);

    return ResponseEntity.ok()
        .contentType(MediaType.IMAGE_PNG)
        .body(stream);
}