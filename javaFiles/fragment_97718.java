int poivot_x = 25; // center
int poivot_y = 0;  // top

translate(poivot_x, poivot_y);
rotate(radians(frameCount/2));
translate(-poivot_x, -poivot_y);

rect(0, 0, 50, 50);