private String getAttachments(Message message, HttpServletRequest request) throws MessagingException, IOException {
    String contentType = message.getContentType();
    String attachFiles="";
    if (contentType.contains("multipart")) {
        // content may contain attachments
        Multipart multiPart = (Multipart) message.getContent();
        int numberOfParts = multiPart.getCount();
        for (int partCount = 0; partCount < numberOfParts; partCount++) {
            MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
            String disposition =part.getDisposition();
            String file=part.getFileName();
            //External attachments
            if (disposition != null && Part.ATTACHMENT.equalsIgnoreCase(disposition)) {
                // this part is attachment
                String fileName = new Date().getTime()+ "_"+ part.getFileName().replaceAll("[^a-zA-Z0-9\\._]+", "_"); //To make attachment name uniq we are adding current datatime before name.
                attachFiles += fileName + ","; //concrete all attachment's name with comma separated.                  
                part.saveFile(new File(request
                        .getSession()
                        .getServletContext()
                        .getRealPath(
                                "/WEB-INF/attechments/"
                                        + fileName)));   //To save the attachment file at specific location.
      //                    LOG.info("\n\t Path :- " +request.getSession().getServletContext().getRealPath("/WEB-INF/attechments/" + fileName));
            }
            //Inline Attachments
            else if (disposition != null && Part.INLINE.equalsIgnoreCase(disposition)) {
                // this part is attachment
                String fileName = new Date().getTime()+ "_"+ part.getFileName().replaceAll("[^a-zA-Z0-9\\._]+", "_"); //To make attachment name uniq we are adding current datatime before name.
              //  attachFiles += fileName + ","; //concrete all attachment's name with comma separated.                  
                part.saveFile(new File(request
                        .getSession()
                        .getServletContext()
                        .getRealPath(
                                "/WEB-INF/attechments/"
                                        + fileName)));   //To save the attachment file at specific location.
 //                    LOG.info("\n\t Path :- " +request.getSession().getServletContext().getRealPath("/WEB-INF/attechments/" + fileName));
            }
            //Inline icons and smileys
            else if(file != null && disposition==null)
            {
                String fileName = new Date().getTime()+ "_"+ part.getFileName().replaceAll("[^a-zA-Z0-9\\._]+", "_");
            //  attachFiles += fileName + ","; //concrete all attachment's name with comma separated.
                 part.saveFile(new File(request
                        .getSession()
                        .getServletContext()
                        .getRealPath(
                                "/WEB-INF/attechments/"
                                        + fileName))); 

            }
        }
    }
     if (attachFiles.length() > 1) {
         attachFiles = attachFiles.substring(0, attachFiles.length() - 1);
     }
    return attachFiles;
}