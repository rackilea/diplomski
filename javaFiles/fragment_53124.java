public GameHandling(Context context, int width, int height, SurfaceHolder holder, Resources resources){
    this.context = context;
    this.holder = holder;
    this.resources = resources;
    this.screenWidth = width;
    this.screenHeight = height;

    this.ball = new Ball(screenWidth, screenHeight, 400, 400);
    this.player = new Bat(screenWidth, screenHeight, 0, 0, Bat.Position.LEFT);
    this.opponent = new Bat(screenWidth, screenHeight, 0, 0, Bat.Position.RIGHT);
}