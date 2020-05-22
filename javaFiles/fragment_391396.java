private void reflectCorner(Rectangle rect) {

    double temp = this.dx;
    this.dx = this.dy;
    this.dy = temp;
    temp = 0;

    if (Math.abs(dx) == Math.abs(dy)) {
        this.dy *= -1;
        this.dx *= -1;
        return;
    }

    if (Math.sqrt(Math.pow(Math.abs(this.getCenterX() - rect.x), 2)
            + Math.pow(Math.abs(this.getCenterY() - rect.y), 2)) <= this.width / 2) {
        System.out.println("topL");
        if (dx < dy) {
            this.dy *= -1;
        } else {
            this.dx *= -1;
        }
        return;
    }
        if (Math.sqrt(Math.pow(Math.abs(this.getCenterX() - (rect.x + rect.width)), 2)
           + Math.pow(Math.abs(this.getCenterY() - (rect.y + rect.height)), 2)) <= this.width / 2) {
        System.out.println("botR");
        if (dx > dy) {
            this.dy *= -1;
        } else {
            this.dx *= -1;
        }
        return;
    }

}