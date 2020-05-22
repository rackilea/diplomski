class Ball{
    float x,y,vx,vy,radius,diameter;
    int type;
    Table table;
    color ballColor;
    // add this variable.
    boolean disappeared = false;
    // your constructor, wallBounce(), push(), collisionDetect()
    void visualize(){
        // only draw the ball when it hasn't disappeared.
        if(!this.disappeared) {
            fill(ballColor);
            stroke(0);
            strokeWeight(2);
            stroke(0);
            ellipse(x,y,diameter,diameter);
        }  
    }
 }