public static void main(String[] args) {
    GameObjects gameOBJ = new GameObjects();

    //Pass the graphics object to the Draw method   
    Window window = new Window(Window.WIDTH, Window.HEIGHT, Window.TITLE);
    Graphics graphics =window.getGraphics() ; 
    gameOBJ.Draw(graphics);
}