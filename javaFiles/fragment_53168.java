public Fire(double x, double y, int direction){
    this.x = x;
    this.y = y;
    this.direction = direction;
}

public void tick(){

    switch (direction){
        case 1:
            x += 10;
            break;
        case 2:
            x -= 10;
            break;
        case 3:
            y += 10;
            break;
        case 4:
            y -= 10;
            break;
    }
}