List<Show> shows = new ArrayList<Show>();
try {
    while(true) {
        shows.add((Show) in.readObject());
} catch (EOFException e) {
   in.close();
   // end of file
}