if(ball.getLinearVelocity().x >= MAX_VELOCITY)
      ball.setLinearVelocity(MAX_VELOCITY,ball.getLinearVelocity().y)
if(ball.getLinearVelocity().x <= -MAX_VELOCITY)
      ball.setLinearVelocity(-MAX_VELOCITY,ball.getLinearVelocity().y);
if(ball.getLinearVelocity().y >= MAX_VELOCITY)
      ball.setLinearVelocity(ball.getLinearVelocity().x,MAX_VELOCITY)
if(ball.getLinearVelocity().y <= -MAX_VELOCITY)
      ball.setLinearVelocity(ball.getLinearVelocity().x,-MAX_VELOCITY);