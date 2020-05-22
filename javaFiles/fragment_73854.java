BufferedImage awtImage = new BufferedImage(frame.getWidth(),frame.getHeight(),BufferedImage.TYPE_INT_RGB);
                File selected = save.getSelectedFile();
                frame.paint(awtImage.getGraphics());
                try {
                    ImageIO.write(awtImage, "png", selected);
                    System.out.println("panel saved as image at: " + selected.getPath());
                } catch (Exception evt) {
                    System.out.println("panel not saved" +     evt.getMessage());
                }