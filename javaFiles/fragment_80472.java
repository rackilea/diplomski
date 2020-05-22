public void show(Circle[] arr) 
{
    /* 
      You could potentially get into a situation where you will NEVER find an empty spot. 
      Add an escape method for the loop.
    */
    int failLimit = 500;
    while(failLimit-- > 0 && isColliding(arr))
    {
        this.x = Math.round(random(0 + r, width - r));
        this.y = Math.round(random(0 + r, height - r));
    }
    ellipse(this.x, this.y, r * 2, r * 2);
    stroke(255);
    fill(255);
}