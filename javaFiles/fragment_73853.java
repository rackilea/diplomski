BufferedImage awtImage = new BufferedImage(frame.getWidth(),frame.getHeight(),BufferedImage.TYPE_INT_RGB);
                BufferedWriter outFile = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                frame.paint(awtImage.getGraphics());
                try {
                    ImageIO.write(awtImage, "png", new File("E://Screen.png"));
                    System.out.println("panel saved as image");
                } catch (Exception evt) {
                    System.out.println("panel not saved" +     evt.getMessage());
                }