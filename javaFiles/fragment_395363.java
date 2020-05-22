@ResponseBody
@RequestMapping("/webjarslocator/{webjar}/**")
public ResponseEntity locateWebjarAsset(@PathVariable String webjar, HttpServletRequest request) {
    try {
        String mvcPrefix = "/webjarslocator/" + webjar + "/"; // This prefix must match the mapping path!
        String mvcPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String fullPath = assetLocator.getFullPath(webjar, mvcPath.substring(mvcPrefix.length()));
        return new ResponseEntity(new ClassPathResource(fullPath), HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}