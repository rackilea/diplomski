int pixel = bitmap.getPixel(x, y);
          int redValue = Color.red(pixel);
          int blueValue = Color.blue(pixel);
          int greenValue = Color.green(pixel);
          hcolor = ByteBuffer.allocate(4).putInt(pixel).array();
          br = (byte) redValue;
          bg = (byte) greenValue;
          bb = (byte) blueValue;

          //tv2.setText("Red: " + redValue + " Green: " + greenValue >+ " Blue: " + blueValue);
          tv2.setText("A: " + hcolor[0] + " R: " + hcolor[1] + " G: " >+ hcolor[2] + " B: " + hcolor[3]);