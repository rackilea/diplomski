private static final CacheControl CACHE_CONTROL = CacheControl.noCache().cachePrivate().mustRevalidate();

@GetMapping(value = "/image", produces = { MediaType.IMAGE_JPEG_VALUE })
public ResponseEntity<byte[]> getImage(WebRequest webRequest) {
    byte[] imageBytes = // Load or generate the image bytes here
    String eTagId     = // Generate a unique eTagId for each version of your image
    if (webRequest.checkNotModified(eTagId))
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);

    return ResponseEntity.ok().cacheControl(CACHE_CONTROL).eTag(eTagId).body(imageBytes);
}