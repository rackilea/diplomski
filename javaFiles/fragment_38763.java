String fileName = "árvíztűrőtükörfúrógép.xls";

String userAgent = request.getHeader("user-agent");
boolean isInternetExplorer = (userAgent.indexOf("MSIE") > -1);

try {
    byte[] fileNameBytes = fileName.getBytes((isInternetExplorer) ? ("windows-1250") : ("utf-8"));
    String dispositionFileName = "";
    for (byte b: fileNameBytes) dispositionFileName += (char)(b & 0xff);

    String disposition = "attachment; filename=\"" + dispositionFileName + "\"";
    response.setHeader("Content-disposition", disposition);
} catch(UnsupportedEncodingException ence) {
    // ... handle exception ...
}