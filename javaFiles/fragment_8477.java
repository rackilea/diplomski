private static List<File> extractAttachment(Multipart multipart) {
    List<File> attachments = new ArrayList<File>();
    try {

        for (int i = 0; i < multipart.getCount(); i++) {
        BodyPart bodyPart = multipart.getBodyPart(i);

        if (bodyPart.getContent() instanceof Multipart) {
            // part-within-a-part, do some recursion...
            extractAttachment((Multipart) bodyPart.getContent());
        }

        System.out.println("bodyPart.getDisposition(): " + bodyPart.getDisposition());
        if (!Part.INLINE.equalsIgnoreCase(bodyPart.getDisposition())) {
            continue; // dealing with attachments only
        }

        InputStream is = bodyPart.getInputStream();
        String filePath = "/tmp/" + bodyPart.getFileName();
        System.out.println("Saving: " + filePath);
        File f = new File(filePath);
        FileOutputStream fos = new FileOutputStream(f);
        byte[] buf = new byte[4096];
        int bytesRead;
        while ((bytesRead = is.read(buf)) != -1) {
            fos.write(buf, 0, bytesRead);
        }
        fos.close();
        attachments.add(f);
        }
    } catch (IOException | MessagingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return attachments;
    }