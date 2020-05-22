public void move() {

    if (isRight) {
        facing = 0;
    } else if (isLeft) {
        facing = 1;
    }

    if (position.y < groundPosition) {
        this.picture = doodleImg[facing==0 ? 0 : 2];
    } else {
        this.picture = doodleImg[facing==0 ? 1 : 3];
    }

    position.x = position.x + speed*(int(isRight) - int(isLeft));

    //border control
    if (position.x+picture.width/2 <= 0) {
        position.x = this.getWidthAndHeight().x-picture.width/2;
    } else if (position.x+picture.width/2 >= this.getWidthAndHeight().x) {
        position.x = 0-picture.width/2;
    }

    //jump
    velocityY -=  gravity * time;
    position.y -=  velocityY * time;
    if (position.y >  groundPosition) {
        position.y =  groundPosition;
        velocityY = 35;
    }
}