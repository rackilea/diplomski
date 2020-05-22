@RequestMapping(value = "/uploadObject", method = RequestMethod.POST)
public String doUpload(UploadedItem uploadItem, 
                      BindingResult result, 
                      @RequestParam("fileData") MultipartFile file,
                      @RequestParam("title") String title,
                      Principal principal) {
//Here you should receive your parameters
}