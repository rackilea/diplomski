public static String imgToBase64String(final RenderedImage img, final String formatName)
{
  final ByteArrayOutputStream os = new ByteArrayOutputStream();

  try
  {
    ImageIO.write(img, formatName, os);
    return Base64.getEncoder().encodeToString(os.toByteArray());
  }
  catch (final IOException ioe)
  {
    throw new UncheckedIOException(ioe);
  }
}