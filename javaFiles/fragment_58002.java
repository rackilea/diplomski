@RequestMapping(value ="/showImage", method = RequestMethod.GET)
@ResponseBody
public List<ImageUpload> getStateList(HttpServletResponse response, HttpServletRequest request) {
    List<ImageUpload> imageUploadList = loginService.getStateList();
    System.out.println(imageUploadList);
    List<ImageUpload> imageListForUi= new ArrayList<ImageUpload>();
    for (ImageUpload m : new ArrayList<ImageUpload>(imageUploadList)) {
        String base64Encoded = javax.xml.bind.DatatypeConverter.printBase64Binary(m.getImage());
        ImageUpload imagepath = new ImageUpload();
        imagepath.setImagePath(base64Encoded);
        imageListForUi.add(imagepath);
    }
    return imageListForUi;
}