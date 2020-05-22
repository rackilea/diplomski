@RequestMapping(value = "/upload", method = RequestMethod.POST)
public String upload(@ModelAttribute("uploadForm")FileUploadModel uploadForm,
                     @RequestParam("files[]") List<MultipartFile> fileList, ModelMap model) throws IOException {
        for(MultipartFile file : fileList){
           try {
               file.transferTo(new File(targetPath+file.getOriginalFilename()));
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
      }
}