response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"PdfName.pdf\"");
            response.setContentLength(outStream.size());

            OutputStream responseOutputStream = response.getOutputStream();
            outStream.writeTo(responseOutputStream);

            responseOutputStream.flush();
            responseOutputStream.close();
            context.responseComplete();