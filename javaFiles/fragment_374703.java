BufferedImage awtImage = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
Graphics g = awtImage.getGraphics();
drawPanel.printAll(g);

try
{
String caminhoImagem = System.getProperty("user.home") + "\\temps\\assinatura.jpg";
FileOutputStream fos = new FileOutputStream(caminhoImagem);
JPEGImageEncoderImpl j = new JPEGImageEncoderImpl(fos);
j.encode(awtImage);
fos.close();
} catch(e) {..... }