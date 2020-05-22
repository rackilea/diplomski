String path = context.getSession().getServletContext().getRealPath("/") + "path to file";  

InputStream inputStream = prepairFileStream(response, path);
if (inputStream == null) return;

FileCopyUtils.copy(inputStream, response.getOutputStream());