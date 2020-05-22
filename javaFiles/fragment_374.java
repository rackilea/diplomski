public static void main(String[] args) throws IOException {
    ZipFile zip = new ZipFile("C:\\Users\\mofh\\Desktop\\test.zip");


    for (Enumeration e = zip.entries(); e.hasMoreElements(); ) {
        ZipEntry entry = (ZipEntry) e.nextElement();
        if (!entry.isDirectory()) {
            if (FilenameUtils.getExtension(entry.getName()).equals("png")) {
                byte[] image = getImage(zip.getInputStream(entry));
                //do your thing
            } else if (FilenameUtils.getExtension(entry.getName()).equals("txt")) {
                StringBuilder out = getTxtFiles(zip.getInputStream(entry));
                //do your thing
            }
        }
    }


}

private  static StringBuilder getTxtFiles(InputStream in)  {
    StringBuilder out = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    String line;
    try {
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
    } catch (IOException e) {
        // do something, probably not a text file
        e.printStackTrace();
    }
    return out;
}

private static byte[] getImage(InputStream in)  {
    try {
        BufferedImage image = ImageIO.read(in); //just checking if the InputStream belongs in fact to an image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    } catch (IOException e) {
        // do something, it is not a image
        e.printStackTrace();
    }
    return null;
}