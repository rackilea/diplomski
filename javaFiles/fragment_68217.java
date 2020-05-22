if (key == KeyEvent.VK_W)  {
    snake.setYD(-1);
    snake.setXD(0);
}

if(key == KeyEvent.VK_S){
    snake.setYD(1);
    snake.setXD(0);
}


if(key == KeyEvent.VK_A){
    snake.setXD(-1);
    snake.setYD(0);
}

if(key == KeyEvent.VK_D){
    snake.setXD(1);
    snake.setYD(0);
}