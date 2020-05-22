if(snake.getFirst().x <= 0){
    snake.getFirst().x = windowWidth/10; //Warp to right
}   
else if (snake.getFirst().x >= windowWidth/10){
    snake.getFirst().x = 0; //Warp to left
}   

if (snake.getFirst().y <= 0){
    snake.getFirst().y = windowHeight/10; //Warp to bottom
}
else if (snake.getFirst().y >= windowHeight/10)
    snake.getFirst().y = 0; //Warp to top