@RequestMapping(value = "/kml")
public void kml(HttpServletRequest request,HttpServletResponse response) throws IOException
{
    InputStream is = request.getServletContext().getResourceAsStream("/WEB-INF/1.0_week_age.kml");;
    IOUtils.copy(is, response.getOutputStream());
}