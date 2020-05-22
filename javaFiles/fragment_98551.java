public static void main(String[] args) {
    try {

        File file = new File("file.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(IMDBInfo.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IMDBInfo imdbInfo = (IMDBInfo) jaxbUnmarshaller.unmarshal(file);
        Movie movie = imdbInfo.getMovie();

        System.out.format(//
                "ImdbRating: %s\nPlot: %s\n", //
                movie.getImdbRating(), //
                movie.getPlot() //
                );

    } catch (JAXBException e) {
        e.printStackTrace();
    }
}