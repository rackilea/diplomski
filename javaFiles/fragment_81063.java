//From your list of balls
ArrayList<BouncingBall> bList = new ArrayList<BouncingBall>();

for(BouncingBall b1 : bList)
    for(BouncingBall b2 : bList)
        if(b1.intersects(b2)){
            //do whatever (such as bouncing off) when the balls collide
            b1.flipDirection();
            b2.flipDirection();              
        }