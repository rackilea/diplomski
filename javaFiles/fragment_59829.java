@RequestMapping(value = "/test")
public ResponseEntity<?> doHandleRequest () {
    CacheControl cacheControl = CacheControl.empty().cachePrivate();
    return ResponseEntity.ok()
                         .cacheControl(cacheControl);
}