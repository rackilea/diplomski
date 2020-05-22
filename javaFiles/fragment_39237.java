XMLInputFactory inputFactory = XMLInputFactory.newFactory() ;
            XMLEventReader eventReader = inputFactory.createXMLEventReader(Files.newBufferedReader(xmlFile.toPath()));
            StringBuilder encodedImageBuffer = new StringBuilder();

            boolean readingImage = false ;

            while (eventReader.hasNext() && encodedImage == null) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement el = event.asStartElement();
                    if ("image".equals(el.getName().getLocalPart())) {
                        readingImage = true ;
                    }
                }
                if (event.isCharacters() && readingImage) {
                    Characters characters = event.asCharacters();
                    encodedImageBuffer.append(characters.getData());
                }
                if (event.isEndElement()) {
                    EndElement el = event.asEndElement();
                    if ("image".equals(el.getName().getLocalPart())) {
                        String encodedImage = encodedImageBuffer.toString();
                        byte[] imageData = Base64.getDecoder().decode(encodedImage);
                        ByteArrayInputStream dataInputStream = new ByteArrayInputStream(imageData);
                        BufferedImage buffImage = ImageIO.read(dataInputStream);
                        Image image = SwingFXUtils.toFXImage(buffImage, null);
                    }
                }
            }