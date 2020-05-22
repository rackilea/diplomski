x = amp * sin((frameCount/period) * TWO_PI);
// enter local coordinate system #1
pushMatrix();
// move to flake position
translate(firstXPos,this.pos.y);
  // enter local coordinate system #2
  pushMatrix();
    // move to updated (oscillated) x position
    translate(x, this.pos.y);
    // rotated from translated position (imageMode(CENTER) helps rotate around centre)
    rotate(frameCount * 0.1);
    // render the image at it's final transformation
    image(snowflakeImg,0,0, imgWidth, imgHeight);
  popMatrix();
popMatrix();