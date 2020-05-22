public class Controller {
    private View theView;
    private Model theModel;

    public Controller(View theView, Model theModel) {
        this.theView = theView;
        this.theModel = theModel;
    }

        public void calculateMethod() {
            double a = 0;
            double b = 0;
            double e = 0;
            try {
                a = theView.scanner.nextDouble();
                b = theView.scanner.nextDouble();
                String jel = theView.scanner.nextLine();
                switch (jel) {
                    case "+": e = a+b; break;
                    case "-": e = a-b; break;
                    case "*": e = a*b; break;
                    case "/": e = a/b; break;
                }
            } catch (Exception error) {
                theView.displayError("Két számot adjon meg!");
            }
        }
}

public class Main {
    public static void main(String[] args) {
        View theView = new View();
        Model theModel = new Model();
        Controller theController = new Controller(theView, theModel);
        theController.calculateMethod();
    }
}