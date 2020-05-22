FileInputStream fis;
            try {
                fis = new FileInputStream(path);
                DICOM d = new DICOM(fis);
                d.run(path);
                Image picture = SwingFXUtils.toFXImage(d.getBufferedImage(), null);
                Button bt = new Button();
                bt.setGraphic(new ImageView(picture));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }