try{
BufferedImage img = ImageIO.read(new File("folder/rgb.jpg"));
int imagem = img.getRGB(evt.getX(), evt.getY());
Color color = new Color(imagem, true); 
    }
catch (IOException ex) {
              Logger.getLogger(Frame1.class.getName()).log(Level.SEVERE, null, ex);
          }