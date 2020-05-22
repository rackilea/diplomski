response.setContentType("image/png");

BufferedImage bi;
OutputStream os = response.getOutputStream();
bi = ImageIO.read(new ByteArrayInputStream(data));
ImageIO.write(bi, "PNG", os);
os.flush();