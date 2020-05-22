String image = "c:/"+rst.getString(8);                  
                                               PDXObjectImage ximage = null;
                                if( image.toLowerCase().endsWith( ".jpg" ) )
                                {
                                    ximage = new PDJpeg(doc, new FileInputStream( image ) );
                                }
                                else if (image.toLowerCase().endsWith(".tif") || image.toLowerCase().endsWith(".tiff"))
                               {
                                    ximage = new PDCcitt(doc, new RandomAccessFile(new File(image),"r"));
                               }
                               else
                                {
                                    BufferedImage awtImage = ImageIO.read( new File( image ) );
                                    ximage = new PDPixelMap(doc, awtImage);

                                }


                               contentStream.drawXObject(ximage, 20, pageYaxis-120, 80, 80);
                                                pageYaxis = pageYaxis-56;