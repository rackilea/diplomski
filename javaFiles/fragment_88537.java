private Response retrieveImage(String uri) {
     byte[] imageBytes = null;
Response r=new Response();
     try {
            URL url = new URL(uri);
            BufferedImage bufferedImage = ImageIO.read(url);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            imageBytes = baos.toByteArray();
            r.setImage(imageBytes);
            r.setStatus(1);
        } catch (Exception ex) {
            r.setStatus(0);
        }
        return r;
    }