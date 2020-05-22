@RequestMapping(value = "/addUpdateSchool", method = RequestMethod.POST)
public String addSchool(@RequestParam("logo") MultipartFile multipartFile, @ModelAttribute SchoolModel schoolModel) {
    String path="";
    try{
        MultipartFile file = multipartFile;
        if(file.getOriginalFilename().trim().length()>0) {
            path=saveFile(file, multipartFile.getOriginalFilename());
        }else{
            path="";
        }
        System.out.println("path: "+path);
    }catch(Exception e){
        e.printStackTrace();
    }
}

public static String saveFile(MultipartFile file, String name) throws IOException{
    byte[] bytes = file.getBytes();
    Random random = new Random();       
    File dir = new File("D:\WebSLCMImages\WebSLCM\"); // Path to Save Image
    if (!dir.exists()){
        dir.mkdirs();
    }
    String path = dir+"/" + getFileName(name) + System.currentTimeMillis() + Math.abs(random.nextInt())+ getFileExtension(name);
    File serverFile = new File(path);
    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
    stream.write(bytes);
    stream.close();
    return path;
}