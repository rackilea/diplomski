public void methodOverloading(Integer movieID, Long renterID, String movieName)
{
    System.out.println();

    if(MovieID != null) {
        this.printMovieInforForMovieID(movieID);
    } 
    if(RenterID != null) {
        this.printMovieInforForRenterID(renterID);
    } 
    if(MovieName != null) {
        this.printMovieInforForMovieNameContaining(movieName);
    } 
}