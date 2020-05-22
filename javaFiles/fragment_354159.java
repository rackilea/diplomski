import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Graphics2D;

public class Creatures extends Moveable2DShape{

    private Color color;
    private int delay, number, t;
    private int xPos, yPos;
    private double xSpeed, ySpeed;
    private final int POINTS = 3;
    private int []x = new int[POINTS];
    private int []y = new int[POINTS];
    private double width, height;
    private boolean dead;
    Ellipse2D.Double body;
    Polygon tail;

    public Creatures(int xPos, int yPos, int shapeWidth, int shapeHeight, int bwidth, int bheight, double xSpeed, double ySpeed, Color c, int type, boolean l){
        super(xPos, yPos, shapeWidth, shapeHeight, bwidth, bheight, xSpeed, ySpeed);
        color = c;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        width = shapeWidth;
        height = shapeHeight;
        t = type;
        dead = l;

    }

    /*@x[3] calculate the x position points of the tail
     *@y[3] calculate the y position points of the tail
     *@tail create the polygon using the points and a defined constant of 3
     *@return the polygon @tail*/
    public Polygon triangle(int xP, int yP){
        x[0] = xP + 100;
        x[1] = x[0];
        x[2] = (int)(xP + width/2);

        y[0] = (int)(yP + (height));
        y[1] = yP;
        y[2] = (int)(yP + height/2);

        tail = new Polygon(x,y,POINTS);

        return tail;

    }

    /*@newBW will determine the new width of the bounding box
     *@return the new bounding box width*/
    public int newBWidth(){
        int newBW;

        newBW = (int)(x[0] - getBoundingBoxMaxX()) + (int)getBoundingBoxWidth();
        return newBW;
    }

    /*when called, the move method of Creatures will move along the x-values\
     *set the new bounding box with the new calculated width */
    public void move(){

        this.xPos=(int) (getXPos() - xSpeed);

        int overShoot = (int) (xPos + getBoundingBoxWidth() - environmentWidth);
        if (xPos <= 0)
        {
          xPos = 0;
          xSpeed = -xSpeed ;
        }
        else if (overShoot > 0)
        {
          xPos = (int)(environmentWidth - getBoundingBoxWidth());
          xSpeed = - xSpeed ;
        }
        /*
          Reflect the object if it goes too far
        */
        overShoot = (int) (yPos + getBoundingBoxHeight() - environmentHeight);
        if (yPos <= 0)
        {
          yPos = 0;
          ySpeed = -ySpeed ;
        }
        else if (overShoot > 0)
        {
          yPos = (int) (environmentHeight - getBoundingBoxHeight());
          ySpeed = - ySpeed ;
        }

        if(xPos == 0 || xPos == 880){
            this.yPos =+ (int)(getYPos() + ySpeed);
        }
        if(yPos == 650){
            this.yPos =+ (int)(getYPos() + ySpeed);
        }

        // move the shape to the new position
        moveTo(xPos,yPos);
        setBoundingBox(getXPos() , getYPos() , newBWidth(), height);
    }

    /*Detect if two bounding boxes intersects with one another if two intersects
     *call the collision response method and @return true, else @return false. */
    public boolean collisionDetect(Moveable2DShape other){
        if(getBoundingBox().intersects(other.getBoundingBox())){
            return true;
        }
        return false;
    }

    /*@other2 cast the Moveable2DShape object into a Creatures object and compare
     *if @other2 object type is greater than the current object then the current object dies
     *if the two objects are equal to each other then change the color of both objects randomly
     *otherwise @other2 dies. */
    public void collisionResponse(Moveable2DShape other){
        int []c2 = new int[3];
        int []c3 = new int[3];

        Creatures other2 = (Creatures) other;
        if (getType() < other2.getType()){
            fishiesDie();
        }else if(getType() == other2.getType()){
            for(int a = 0; a < 3; a++){
                c2[a] = (int)(Math.random()*255) + 1;
                c3[a] = (int)(Math.random()*255) + 1;
            }
            color = new Color(c2[0], c2[1], c2[2]);
            other2.color = new Color(c3[0], c3[1], c3[2]);
        }else{
            other2.fishiesDie();
        }

    }


    /*@return the type of the fish */
    public int getType(){
        return t;
    }

    /*@dead equals to true when called */
    public void fishiesDie(){
        dead = true;
    }

    /*@return dead */
    public boolean isDead(){
        return dead;
    }

    /*@body draw the general body ellipse
     *@g set the colour and draw the general fish shape(body and tail)*/
    public void draw(Graphics2D g){
        body = new Ellipse2D.Double((int)getXPos(), (int)getYPos() , width, height);
        triangle((int)getXPos(), (int)getYPos());
        //g.draw(getBoundingBox());
        g.setColor(color);
        g.fill(body);
        g.fill(tail);


    }


}