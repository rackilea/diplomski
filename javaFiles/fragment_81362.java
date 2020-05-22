public class bird {

    private int hitCount;

    public bird(){
        //instantiates the bird, set initial values here
        hitCount = 0;
    }

    public void setHitCount(int hitCount){
        //pass in a number as parameter to set your instance var hitCount
        this.hitCount = hitCount;
    }

    public int getHitCount(){
        //returns the value of your instance variable
        return hitCount;
    }
}