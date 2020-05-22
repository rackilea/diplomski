void draw() {
    //   image(img, 0, 0);
    background(255);    

    for (int i= 0; i<4;i++){
        buts[i].update(mouseX, mouseY);
        buts[i].hover(); 
    }

    // I want to whenever the mouse is clicked on a button something happens,
    // but not just while the mouse is pressed. 
    if (clicked_button >= 0) {
        UIFUNC(clicked_button);
        clicked_button = -1;
    }

    for (int i= 0; i<4;i++){                                       
        item = inventory.get(i);  
        fill(255,0,0);
        textSize(16);
        text(item,rectX+awidth/10,rectY+(rectSize2+10)*i+30); }
}