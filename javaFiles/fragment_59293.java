void draw()
{
    background(10);

    for (int i = 0; i < wins.length; i ++) {
        wins[i].update_window();
    }

    for (int i = 0; i < wins.length; i ++) {
        wins[i].draw_window();
    }
}