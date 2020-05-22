//request is an instance of HttpServletRequest

  File uploadDirectory = new File(request.getSession().getServletContext().getRealPath("/uploads"));

  if (!uploadDirectory.exists()) {
      uploadDirectory.mkdirs();
  }

  File reportFile = new File(reportDirectory.getAbsolutePath(), fileName);

  String requestUrl = request.getRequestURL().toString();
  requestUrl = requestUrl.substring(0, requestUrl.lastIndexOf("/") + 1) + "uploads/" + fileName;
  return requestUrl;