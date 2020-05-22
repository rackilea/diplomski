BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
Graphics gr = image.getGraphics();
gr.setColor(new Color(0, 0, 0, 0)); // last component is alpha channel. 
                                    // 0 - transparent, 255 - opaque
gr.fillRect(0, 0, 100, 100):
// Now image is transparent