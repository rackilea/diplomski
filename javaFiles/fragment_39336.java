public class MyRect implements Comparable {
    int width;      //width of the rectangle will probably not change
    int height;     //this might be the value you want to compare in compareTo() 
    point position;

    ...

    //getters and setters yada yada
    public int getHeight(){
        return this.height;
    }

    ...

    @Override
    public int compareTo(Object otherRect){

        // if this rectangle's height is greater than otherRect the difference should 
        // be positive, if equal 0, and if less than the difference will be negative
        // exactly as specification for compareTo() states.

        return this.height - (MyRect)otherRect.getHeight();
    }
}