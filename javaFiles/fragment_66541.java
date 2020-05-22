MimeMultipart mp = (MimeMultipart) attachment.getContent();
for (int i = 0; i < mp.getCount(); i++) {
    Part bp = mp.getBodyPart(i);
    if (bp.isMimeType("text/*")) {
        String text = (String)bp.getContent();
        //process text
    } else if (bp.isMimeType("image/*")) {
        InputStream is = bp.getInputStream();
        //process image 
    }
}