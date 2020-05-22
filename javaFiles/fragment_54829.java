@RequestMapping(value = "/upload", method = RequestMethod.POST)
public ResponseEntity executeByPost(WebRequest webRequest)
{
    MultiValueMap<String, MultipartFile> files = ((StandardMultipartHttpServletRequest) ((ServletWebRequest) webRequest).getRequest()).getMultiFileMap();
    return ResponseEntity.ok(files.keySet());
}