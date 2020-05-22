private Response retrieveImage(String uri)throws CustomException {
         byte[] imageBytes = null;
         try {
                URL url = new URL(uri);
                BufferedImage bufferedImage = ImageIO.read(url);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                imageBytes = baos.toByteArray();
            } catch (Exception ex) {
                throw new CustomException(ex.getLocalizedMessage());
            }
            return imageBytes;
        }