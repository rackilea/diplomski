import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library
{
    String address;
    Map<String, Movie> movieLibrary;

    public Library(String libraryAddress)
    {
        address = libraryAddress;
        this.movieLibrary = new HashMap<String, Movie>();
    }

    public void addMovie(Movie... movies)
    {
        for (Movie item : movies)
        {
            this.movieLibrary.put(item.getTitle(), item);
        }
    }

    public void borrowMovie(String movieTitle)
    {
        Movie movie = this.movieLibrary.get(movieTitle);

        if (movie == null) // Not in libray
        {
            System.out.println("Sorry, this movie is not in our catalog.");
        }
        else
        {
            if (movie.isBorrowed())
            {
                System.out.println("Sorry, this movie is already borrowed.");
            }
            else
            {
                try
                {
                    movie.borrow();
                    System.out.println("You have successfully borrowed " + movieTitle);
                }
                catch (Exception e)
                {
                    System.out.println("An internal error has occured while attempting to borrow " + movieTitle + ", error details: " + e.getMessage());
                }
            }
        }
    }

    public void returnMovie(String movieTitle)
    {
        Movie movie = this.movieLibrary.get(movieTitle);

        if (movie == null) // Not in libray
        {
            System.out.println("Sorry, this movie is not in our catalog.");
        }
        else
        {
            if (movie.isBorrowed())
            {
                try
                {
                    movie.returnMovie();
                    System.out.println("You successfully returned " + movieTitle);
                }
                catch (Exception e)
                {
                    System.out.println("An internal error has occured while attempting to return " + movieTitle + ", error details: " + e.getMessage());
                }
            }
            else
            {
                System.out.println("Sorry, this movie is has not been borrowed.");
            }
        }
    }

    public static void printOpeningHours()
    {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress()
    {
        System.out.println(address);
    }

    public void printAvailableMovies()
    {
        Collection<Movie> movies = this.movieLibrary.values();

        if (movies.size() > 0)
        {
            for (Movie movie : movies)
            {
                if (!movie.isBorrowed())
                {
                    System.out.println(movie.getTitle());
                }
            }
        }
        else
        {
            System.out.println("No movie in catalog.");
        }

    }

    public static void main(String[] args)
    {
        // Create two libraries
        Library firstLibrary = new Library("Plot 11, Kafene Road");
        Library secondLibrary = new Library("Plot 28, Kayembe Road");

        // Add four movies to the first library
        firstLibrary.addMovie(new Movie("Yogera"));
        firstLibrary.addMovie(new Movie("The Last King of Scotland"));
        firstLibrary.addMovie(new Movie("The Hostel"));
        firstLibrary.addMovie(new Movie("Christmas in Kampala"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow Christmas in Kampala from both libraries
        System.out.println("Borrowing Christmas in Kampala:");
        firstLibrary.borrowMovie("Christmas in Kampala");
        firstLibrary.borrowMovie("Christmas in Kampala");
        secondLibrary.borrowMovie("Christmas in Kampala");
        System.out.println();

        // Print the titles of all available movies from both libraries
        System.out.println("Movies available in the first library:");
        firstLibrary.printAvailableMovies();
        System.out.println();
        System.out.println("Movies available in the second library:");
        secondLibrary.printAvailableMovies();
        System.out.println();

        // Return Christmas in Kampala to the first library
        System.out.println("Returning Christmas in Kampala:");
        firstLibrary.returnMovie("Christmas in Kampala");
        System.out.println();

        // Print the titles of available movies from the first library
        System.out.println("Movies available in the first library:");
        firstLibrary.printAvailableMovies();

    }
}