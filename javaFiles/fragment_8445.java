public class FilmSystem{

    private String filmName;
    private String lecture;
    private String ageRating;
    private String ticketCost;
    private int noOfSeats;

    public FilmSystem(String film, String lect, String age, 
                      String price, int seats){
        filmName = film;
        lecture = lect;
        ageRating = age;
        ticketCost = price;
        noOfSeats = seats;

    }

    public String getFilmName(){
        return filmName;
        }

}

public class FilmSystemTest{

    @Test
    public void shouldReturnCorrectName(){
        FilmSystem filmSystem = new FilmSystem("Ocean's Eleven", "", "", "", 0);

        Assert.assertEquals("Ocean's Eleven", filmSystem.getFilmName());
    }
}