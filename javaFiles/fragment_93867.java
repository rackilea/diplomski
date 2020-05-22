// for storage so we don't load it for each mouse-over
HashMap<String, ImageIcon> images = new HashMap<String, ImageIcon>();

void setIcon(JLabel button, String image)
{
  if (images.containsKey(image))
    return images.get(image);
  else
  {
    String path = "/ip/imag/" + image + ".png";
    ImageIcon icon = new ImageIcon(getClass().getResource(path));
    images.put(image, icon);
    return icon;
  }
}