// float x0, y0; // old position
// float x1, y1; // requested position
// float x = x0, y = y0; // current position
// float total_steps; // total steps to split the move between
// float step_x = ( x1 - x0 ) / total_steps;
// float step_y = ( y1 - y0 ) / total_steps;

while( Math.round(x) != x1 ) {
    x += step_x;
    y += step_y;
    frame.repaint();
    sleep(); // Thread.sleep(200)
}