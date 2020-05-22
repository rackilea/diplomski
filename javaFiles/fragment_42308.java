@RequestMapping(value = "/save-avatar", method = RequestMethod.POST)
public void UploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {

    Iterator<String> itr = request.getFileNames();
    MultipartFile file=null;

    while (itr.hastNext()) {
        file = request.getFile(itr.next());
        String name = request.getParameter("name");

        //Do your stuff here.......
    }
}