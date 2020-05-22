@PostMapping("/uploadPic")
public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile multipartFile){
    String cloudinaryImgURL=null;
    try {
        File fileDir = new File("rowFiles");
        if (! fileDir.exists()){
            fileDir.mkdir();
        }
        String fileName=multipartFile.getOriginalFilename();
        File physicalFile=new File(multipartFile.getOriginalFilename());
        FileOutputStream fout=new FileOutputStream(fileDir.getName()+"/"+physicalFile);
        fout.write(multipartFile.getBytes());
        fout.close();
        File toUpload = new File("rowFiles/"+fileName);
        Cloudinary cloudinary = new Cloudinary();
        System.out.println("API Key:"+cloudinary.config.apiKey);
        Map params = ObjectUtils.asMap("public_id", "SRWRestImageBase/"+fileName);
        Map uploadResult = cloudinary.uploader().upload(toUpload, params);
        toUpload.delete();
        System.out.println("==============>>"+uploadResult.get("url"));
        cloudinaryImgURL=uploadResult.get("url").toString();
    } catch (Exception e) {
        System.out.println("upload:"+e.getMessage());
    }
    return new ResponseEntity<Object>("File uploaded successfully:"+cloudinaryImgURL,HttpStatus.OK);
}