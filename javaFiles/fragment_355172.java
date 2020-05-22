response.reset();
        response.setContentType("application/pdf");
        response.setContentLength(pdfContent.length);
        response.setHeader("Content-Disposition", "inline; filename=RANDOMFILE.pdf");
        response.addHeader("Accept-Ranges", "bytes");
        response.getOutputStream().write(pdfContent);
        response.getOutputStream().flush();
        response.getOutputStream().close();