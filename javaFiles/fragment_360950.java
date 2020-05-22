//Representation of the act of rating something
public class Rating {
    private Rate rate;
    private ThingToRate thing;

    //getters/setters/stuff

}

//Possible choices for rating something
public enum Rate {
    VERY_BAD,
    BAD,
    MEDIOCRE,
    GOOD,
    VERY_GOOD,  
    EXCELLENT;
}