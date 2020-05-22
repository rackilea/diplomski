startCounter = 8;
                balls = new ArrayList<>();

             while (balls.size()<amount){
                 int i = 0;

                    diameter = random.nextInt(30) + 10 + 
                diameterRange;//generate diameter value for ball

                    startCounter = random.nextInt(800) + 100;
                    startCounterY = random.nextInt(400) +100;
                    BouncingBall ball = makeBall(startCounter, 
                   startCounterY, diameter, i);
                    if (Physics.Collision(ball, balls)||ball.getXPosition()> 
                    850||ball.getYPosition()>550){

                        continue;
                    }

                    balls.add(ball);
                    i++;

                  }