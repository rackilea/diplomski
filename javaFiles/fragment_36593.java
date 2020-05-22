BufferedImage image = ImageIO.read(inputFile);

      if (image.getColorModel().getColorSpace().getType() == ColorSpace.TYPE_GRAY) {
        System.out.println("is grayscale");
      }

      // create jpegEncode for output image
      JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(new FileOutputStream(outputFile));




      // create jpeg encoder from getting defaul value from input buffered
      // image
      JPEGEncodeParam jpegEncodeParam = jpegEncoder.getDefaultJPEGEncodeParam(image);
      // setting up density unit paramter
      jpegEncodeParam.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
      // setting up jpeg encode parameter
      jpegEncoder.setJPEGEncodeParam(jpegEncodeParam);
      // set quality parameter
      jpegEncodeParam.setQuality(0.75f, false);
      // set X-resolution
      jpegEncodeParam.setXDensity(X_DPI);
      // set Y-resolution
      jpegEncodeParam.setYDensity(Y_DPI);
      // encode output image
      jpegEncoder.encode(image, jpegEncodeParam);
      // flush the buffer image
      image.flush();