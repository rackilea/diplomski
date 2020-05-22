try {
   final JAXBContext context = JAXBContext
         .newInstance(ShowingToday.class);
   final Unmarshaller unmarshaller = context.createUnmarshaller();
   final ShowingToday showingToday = unmarshaller.unmarshal(
         new StreamSource(new File("absolute path of file here")),
         ShowingToday.class).getValue();

} catch (final Exception e) {
   // Do something useful here
}