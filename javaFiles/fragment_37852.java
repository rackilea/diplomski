for (int i = 0; i < snake.size(); i++) {

        if ((x == snake.get(i).x) && y == snake.get(i).y) {
            hit();
        }
    }