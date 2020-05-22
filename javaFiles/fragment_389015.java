barcode.setBarWidth(1);
                   barcode.setResolution(203);
                   barcode.setBarHeight(1);
                   Font font=new Font("Plain",Font.PLAIN,8);
                   barcode.setFont(font);
                        //File f = new File("mybarcode.png");

                       // System.out.println(f.getAbsolutePath());
                        BarcodeImageHandler.writePNG(barcode, os);
                        //BarcodeImageHandler.savePNG(barcode, f);

                    }

                     catch (Exception e) {
                        System.out.println(e.getMessage());
                    }