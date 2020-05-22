@RequestMapping(value="/upload.json", method = RequestMethod.POST) 
public @ResponseBody Map<String, Object> upload(HttpServletRequest request) {
    if (request instanceof MultipartHttpServletRequest) {
        // process the uploaded file
    }
    else {
        // other logic
    }
}