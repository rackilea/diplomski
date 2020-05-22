@RequestMapping(value = "/kml")
public @ResponseBody byte[] kml(HttpServletRequest request,HttpServletResponse response) throws IOException
{
    InputStream is = request.getServletContext().getResourceAsStream("/WEB-INF/1.0_week_age.kml");
    return IOUtils.toByteArray(is);
}