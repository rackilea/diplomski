@RequestMapping(method = RequestMethod.GET, value = "/getVideoIcon")
@ResponseBody
public FileSystemResource getVideoIcon(HttpServletRequest request) throws IOException {
    String path = request.getSession().getServletContext().getRealPath("/resources/images")+"/video_icon.png";
    return new FileSystemResource(new File(path));
}