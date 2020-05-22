@RequestMapping(value="addMultiDisCar",method=RequestMethod.POST)
public @ResponseBody Map<String, Object> addMultiDisCar(HttpServletRequest request){
                   MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                   List<MultipartFile> files = multipartRequest.getFiles("files");
                   //...
                   //Now you have a List of Multipartfile that you can simply change to File...
}