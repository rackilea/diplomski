if (ball.location.x+ball.diameter/2 >= primary.location.x-+primary.paddleWidth/2 && 
    ball.location.y >= primary.location.y-primary.paddleLength/2 &&
    ball.location.y <= primary.location.y+primary.paddleLength/2) {

    ball.direction.x *= -1;
}