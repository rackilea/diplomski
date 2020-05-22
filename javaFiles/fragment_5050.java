public @ResponseBody String upload(HttpServletRequest request, HttpServletResponse response,
@RequestPart("dataFile") MultipartFile file ){ 
    if(file!=null){
        return "1";
    }
    return "0";
}