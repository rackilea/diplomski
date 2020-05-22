ImageReader reader; // the reader for your format
reader.setInput(input); // your input

// Create image from type specifier
ImageTypeSpecifier spec = reader.getImageTypes(0).next();
BufferedImage destination = spec.createBufferedImage(reader.getWidth(), reader.getHeight();

ImageReadParam param = reader.getDefaultReadParam();
param.setDestination(destination);

reader.read(0, param);  // Image will be decoded to destination