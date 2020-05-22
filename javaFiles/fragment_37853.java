public void snake() {

if (snake.size() == 0) {
    b = new Body(x, y);
    snake.add(b);

}
move();

if (started) {

    for (int i = 0; i < snake.size(); i++) {

        if ((x == snake.get(i).x) && y == snake.get(i).y) {
            hit();
        }
    }

}
b = new Body(x, y);
snake.add(b);

if (snake.size() > size) {
        snake.remove(0);
}

}