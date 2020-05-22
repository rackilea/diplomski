@RequestMapping(path = "/attachmentPath", method = RequestMethod.POST)
public Response attachmentPath(HttpServletRequest request, Attachment attachment , @RequestParam(value = "file") MultipartFile file) throws IllegalStateException, IOException {
    String orgName = file.getOriginalFilename();
    String absolutePathToImages = request.getSession().getServletContext().getRealPath("/images/");
    String filePath = absolutePathToImages + orgName;
    File dest = new File(filePath);
    //check destination exists, if not create it
    if(!dest.exists())
    {
       new File(dest).mkdir();
    }
    try { 
       file.transferTo(dest); 
    }
    catch (IllegalStateException e) 
    { 
        e.printStackTrace();
    }