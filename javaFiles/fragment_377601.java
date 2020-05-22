for(int x = 0; x< 10 ; x++){
    for(int y = 0; y< 10 ; y++){

        sq[x][y] = new Point(x/10.0f, y/10.0f);

        gl.glPushMatrix();
        gl.glTranslatef(x/10.0f, y/10.0f, -5.0f);
        sq[x][y].draw(gl, 0, 1, 0);
        gl.glPopMatrix();
    }
}