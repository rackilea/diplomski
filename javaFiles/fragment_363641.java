void draw(){
    background(0);

    int w = 300;
    int h = 300;
    PGraphics pg = CreateTile(w, h, 0.01);

    for (int i = 0; i < 3; ++i) { 
        for (int j = 0; j < 3; ++j) {
            image(pg, w*i, h*j);
        }
    }
}