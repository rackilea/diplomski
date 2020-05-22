@RequestMapping(
        value = "/new/upload", method = RequestMethod.POST,
        produces = BaseController.MIME_JSON, consumes = BaseController.MIME_JSON
)
public @ResponseBody HttpResponse performSpotUpload(@RequestBody final SpotDTO spot) {
    // ...
}