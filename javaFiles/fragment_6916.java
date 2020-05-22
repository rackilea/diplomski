import java.util.*;
public class MovieRating 
{

// instance variables
private String description;
private int maxRating;
private int rating;

/*This is the constructor
  Note the use of .this - the expression is used to call the class form withing  
  itself*/
public MovieRating(String description, int maxRating, int rating) {
    this.setDescription(description);
    this.setMaxRating(maxRating);
    this.setRating(rating);
}

/*These are the getters and setters - get is used for getting the value
  and set is used for assigning a value to it*/
public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public int getMaxRating() {
    return maxRating;
}

public void setMaxRating(int maxRating) {
    this.maxRating = maxRating;
}

public int getRating() {
    return rating;
}

public void setRating(int rating) {
    this.rating = rating;
}

//This is a method for the printing commands - notice the use of the get methods//
public void printRatings()
{
    System.out.println("The max rating is: " + this.getMaxRating() );
    System.out.println("Your rating is: " + this.getRating() );

    System.out.println("The rating for" + this.getDescription() + " is " + 
                        this.getRating()); 
    System.out.println("while the max rating was " + this.getMaxRating();
    }

// PostCondition: Will write maxRating, rating and description to the user.

/*Precondition: description, enter the rating
  Note the use of this.setRating()*/
public void readInput()
{
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What would you rate the movie \"American History x\" out of ten");
    System.out.println(description);
    this.setRating(keyboard.nextInt());
}
//postcondition: rating will be set to user's input for the movie American History x.