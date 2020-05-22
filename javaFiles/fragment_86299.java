private Ball[] arr; // ball array
private int ballNum; // the number of the balls on the screen
private float radius; // the radius of the balls
private int count;// count if to sleep or not
private Timer timer;

public BallCollection(int ballNum) {

    //check the value of ballNum here.

    this.arr = new Ball[ballNum];
    this.ballNum = ballNum;
    this.radius = 50;
    this.count = 0;

    for (int i = 0; i < arr.length; i++) {
        this.arr[i] = new Ball(this.radius);
    }
    //check the array size of arr here.
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            //if (count < arr.length + 1) {
            count = count + 1;
            //}
            System.out.println("" + count);
        }
    }, 0, 2000);
}

private boolean isBumpWithRest(Ball[] few, Ball one) {
    for (int i = 0; i < this.arr.length; i++) {
        if (this.arr[i] != one) {
            if (this.arr[i].isBump(one)) {
                return true;
            }
        }
    }
    return false;
}

public void setBalls(Canvas canvas) {
    Random rnd = new Random();
    for (int i = 0; i < this.ballNum; i++) {
        int x = (int) (rnd.nextInt((int) (canvas.getWidth() - 4 * this.radius)) + 2 * this.radius);
        int y = (int) (rnd.nextInt((int) (canvas.getHeight() - 4 * this.radius)) + 2 * this.radius);

        this.arr[i].setX(x);
        this.arr[i].setY(y);
        while (this.isBumpWithRest(this.arr, this.arr[i]) && arr[i].getX() != 0) {
            x = (int) (rnd.nextInt((int) (canvas.getWidth() - 2 * this.radius)) + this.radius);
            y = (int) (rnd.nextInt((int) (canvas.getHeight() - 2 * this.radius)) + this.radius);
            this.arr[i].setX(x);
            this.arr[i].setY(y);
        }
    }
}

public void draw(Canvas canvas) {
    Paint p = new Paint();
    p.setColor(Color.RED);
    p.setTextSize(50);
    for (int i = 0; i < this.count; i++) {
        arr[i].draw(canvas, p);
        canvas.drawText("" + this.count, 100, 100, p);


    }
}