@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
public String importQuestion(@Valid @RequestParam("uploadedFileName") 
MultipartFile multipart,  BindingResult result, ModelMap model) {
   logger.debug("Post method of uploaded Questions ");

    logger.debug("Uploaded file Name : " + multipart.getOriginalFilename());
   return "importQuestion";
}