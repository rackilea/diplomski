public static void main(String[] args) {

    // view is declared as class-variable
    view = new View();

    MainController mcontroll = new MainController(view);

    view.getFrame().setVisible(true);
}