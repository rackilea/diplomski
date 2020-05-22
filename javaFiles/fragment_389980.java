public class Sprite{
    private int left,right;//bounding box left<right and top>bottom
    private int top,bottom;

    public final boolean collidesWith(Sprite other){
        if(this.left>other.right || other.left>other.right)return false;
        if(this.bottom>other.top || other.bottom>other.top)return false;

        return true;
    }
}