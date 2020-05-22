FileInputStream baos = new FileInputStream("c:\\temp\\test.pdf");

             response.setHeader("Expires", "0");
             response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
             response.setHeader("Pragma", "public");
             response.setContentType("application/pdf");
             response.addHeader("Content-Disposition", "attachment; filename=test.pdf");

             OutputStream os = response.getOutputStream();

             byte buffer[] = new byte[8192];
             int bytesRead;

             while ((bytesRead = baos.read(buffer)) != -1) {
                 os.write(buffer, 0, bytesRead);
             }

             os.flush();
             os.close();