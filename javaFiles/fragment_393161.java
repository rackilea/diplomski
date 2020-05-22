JFrame frame = new JFrame(); 
    frame.setTitle("Polygons"); 
    frame.setSize(550, 550); 
    Container contentPane = frame.getContentPane(); 
    try {
     JLabel sentenceLabel= new JLabel(new ImageIcon(
                  ImageIO.read(new URL(
                     "http://www.google.ru/intl/en_com/images/logo_plain.png"))));
     contentPane.add(sentenceLabel);
    } catch (MalformedURLException ex) {
        // TODO Auto-generated catch block
        ex.printStackTrace();
    } catch (IOException ex) {
        // "http://img.yandex.net/i/wiz"+imgType.trim()+".png"
        ex.printStackTrace();
    }
    frame.show();