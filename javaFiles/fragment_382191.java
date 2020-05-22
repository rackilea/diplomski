int clicked_button = -1;

void mouseClicked() {
    for (int i= 0; i<4; i++) {
         if (buts[i].rectOver) {
             clicked_button = i;
         }
    }
}