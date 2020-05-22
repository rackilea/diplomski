import java.util.Scanner;

public class MovieTester {

    public static void main(String [] args){

        Movie[] movies = new Movie[3];

        try (Scanner string_input = new Scanner(System.in);
            Scanner int_input = new Scanner(System.in);) // Try with resources
        {
            for (int i = 0; i < 3; i++) {
                Movie movie = new Movie();

                // Enter Details For Movie
                System.out.println("Please Enter The Title Of Movie: ");
                movie.setTitle(string_input.nextLine());
                System.out.println("Please Enter The Genre Of Movie: ");
                movie.setGenre(string_input.nextLine());
                System.out.println("Please Enter The Rating Of Movie: ");
                movie.setRating(int_input.nextInt());
                System.out.println();

                movies[i] = movie;
            }

            // Play Movies
            for (int i = 0; i < movies.length; i++) {
                Movie movie = movies[i];

                System.out.println("Title: " + movie.getTitle());
                System.out.println("Genre: " + movie.getGenre());
                System.out.println("Rating: " + movie.getRating());
                movies[i].playIt();
                System.out.println();
            }
        }

    }//end main method
}//end class