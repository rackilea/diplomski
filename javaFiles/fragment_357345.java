public class MyRect {

    public static Paint paint;  // default paint use for all my MyRect objects

    static {

        paint=new Paint();
        paint.setColor(Color.RED);
    }

    public float x,y,width,height;
    public float roundStrength=30;

    public MyRect(float x, float y, float width,float height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public MyRect(float x, float y, float width,float height,float roundStrength){
        this(x,y,width,height);
        this.roundStrength=roundStrength;
    }

    public void draw(Canvas canvas){
         canvas.drawRoundRect(x-width/2,y-height/2,x+width/2,y+height/2,roundStrength,roundStrength,paint);
    }
}