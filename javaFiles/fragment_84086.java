public void imageCapsMarshal(List<ImageCap> imageCaps, File outFile) {
        try {
            jaxbMarshaller.marshal(new ImageCapList(imageCaps), outFile);
        } catch (JAXBException e) {
            // HANDLE EXCEPTIONS
        }
    }