//to check for collision using intersects() method
for(BouncingBall b1 : bList)
    for(BouncingBall b2 : bList)
        if(b1.getBounds().intersects(b2.getBounds())){
            //do whatever (such as bouncing off) when the balls collide
            b1.flipDirection();
            b2.flipDirection();              
        }