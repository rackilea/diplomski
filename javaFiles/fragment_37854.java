public void food() {
    if (foods.size() == 0) {
        int ok = 0;
        int rx = 0;
        int ry = 0;
        while (ok != 1) {
            rx = (int) (rand.nextInt(700) + 1);
            ry = (int) (rand.nextInt(700) + 1);

            if ((rx % 10) == 0 && (ry % 10) == 0) {
                ok = 1;
            }
        }
        f = new Food(rx, ry);
        foods.add(f);
    }

    if (snake.get(snake.size() - 1).x == foods.get(0).x
            && snake.get(snake.size() - 1).y == foods.get(0).y) {
        foods.remove();
        size++;
        grade += 100;
        started = true;
    }
}