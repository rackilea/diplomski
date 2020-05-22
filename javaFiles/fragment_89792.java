public void rightClick() {
    TimerTask task;

    task = new TimerTask() {
        @Override
        public void run() {
            System.out.println("X: " + mouseConverter(mouseX) + " Y: " + mouseConverter(mouseY));
            System.out.println("SX: " + select.x + " SY: " + select.y);
            if (select.x != mouseConverter(mouseX) || select.y != mouseConverter(mouseY)) {
                int[][] path = select.ai().getPath(arena, mouseConverter(mouseX), mouseConverter(mouseY), blocked);
                select.move(path[0][0], path[0][1]);
                repaint();
            }
            else {
                cancel();

            }
        }
    };
    timer.schedule(task, 0, ANIMATION_DELAY);

}