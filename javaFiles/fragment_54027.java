import java.util.HashSet;
import java.util.Set;

public class Animals{
    Set<String> animals;
    //String newanimal; delete this!

    //Constructor allows users to set animals using a set.
    public Animals (Set<String> animals){
        this.animals = animals;
        }

    //This default constructor is needed because you did not do Set<String> animals = new HashSet();
    public Animals()
    {
        this.animals = new HashSet();
    }

    //This method adds new elements to the animal set. What you did is wrong, so look over and compare
    public void setAnimals(String newanimal){
        animals.add(newanimal);
    }

    //The toString method you were asking about. I used StringBuilder but you can use someString += item + "\n".
    @Override
    public String toString(){
        /* this is where my problem is i want to return the set (below), 
           however i also need each animal to be on a new line */
        StringBuilder stringBuilder = new StringBuilder();
        for(String item : animals)
        {
            stringBuilder.append(item).append("\n");
        }

        return stringBuilder.toString();
    }
}