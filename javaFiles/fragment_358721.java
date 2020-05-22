public class Movie
{
    public String title;
    boolean borrowed;

    // Creates a new Movie
    public Movie(String movieTitle)
    {
        title = movieTitle;
    }

    // Marks the movie as rented
    void borrow() throws Exception
    {
        if (this.borrowed)
        {
            throw new Exception("The movie <" + this.title + "> is already borrowed - cannot borrow it again");
        }
        else
        {
            this.borrowed = true;
        }
    }

    // Marks the movie as not rented
    void returnMovie() throws Exception
    {
        if (this.borrowed)
        {
            this.borrowed = false;
        }
        else
        {
            throw new Exception("The movie <" + this.title + "> has not been borrowed - it cannot be returned");
        }
    }

    // Returns true if the movie is rented, false otherwise
    public boolean isBorrowed()
    {
        return this.borrowed;
    }

    // Returns the title of the movie
    public String getTitle()
    {
        return title;
    }

    public static void main(String[] arguments) throws Exception
    {
        // Small test of the Movie class
        Movie example = new Movie("Christmas in Kampala");
        System.out.println("Title (should be Christmas in Kampala): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrow();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returnMovie();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
}