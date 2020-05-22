if (response.getContentType().equalsIgnoreCase("image/png")) {
            BufferedImage image = ImageIO.read(response.getInputStream());
            return image;
        } else {
            StringWriter writer = new StringWriter();
            IOUtils.copy(response.getInputStream(), writer);
            String error = writer.toString();
            System.out.println(error);
            return null;
        }