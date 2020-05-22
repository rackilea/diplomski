catch (Exception e) {
    resourceResponse.setProperty(resourceResponse.HTTP_STATUS_CODE, "500"); 
    PrintWriter out = resourceResponse.getWriter();
    out.println("error");
    out.close();
}