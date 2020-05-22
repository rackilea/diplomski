ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    wb.write(outByteStream);

    byte [] outArray = outByteStream.toByteArray();
    HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
   HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

    ServletResponseUtil.sendFile(request, response, "result.xls" ,outArray, ContentTypes.APPLICATION_VND_MS_EXCEL);