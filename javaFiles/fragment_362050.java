@Override
protected void writeAjaxPageHtmlVaadinScripts(Window window,
                                              String themeName, Application application, BufferedWriter page,
                                              String appUrl, String themeUri, String appId,
                                              HttpServletRequest request) throws ServletException, IOException {
  page.write("<script type=\"text/javascript\">\n");
  page.write("//<![CDATA[\n");
  page.write("document.write(\"<script language='javascript' src='" + appUrl + "/VAADIN/scripts/jquery/jquery-1.4.4.min.js'><\\/script>\");\n");
  page.write("document.write(\"<script language='javascript' src='" + appUrl + "/VAADIN/scripts/highcharts/highcharts.js'><\\/script>\");\n");
  page.write("document.write(\"<script language='javascript' src='" + appUrl + "/VAADIN/scripts/highcharts/modules/exporting.js'><\\/script>\");\n");
  page.write("//]]>\n</script>\n");
  super.writeAjaxPageHtmlVaadinScripts(window, themeName, application,
      page, appUrl, themeUri, appId, request);
}