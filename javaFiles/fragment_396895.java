@RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("coverFile") MultipartFile file,
            @RequestParam(value = "type", required = true) String type,
            @RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "pages", required = true) String pages, HttpServletResponse response, Model model)
            throws JSONException {