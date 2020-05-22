@RequestMapping(value = "/upload", method = RequestMethod.POST)
        public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file, Model model) {
       //Upload file and process

       JsonObject jo = Json.createObjectBuilder().add(path, folderPath.toString())
                                .add(aContentsAttrib, aContents)
                                .add(bContentsAttrib, bContents).build();


       return jo.toString();
}