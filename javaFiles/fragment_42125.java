public class FxThreeNodes extends Application {

    private abstract class CycledView extends StackPane { // Choose whatever is most appropriate class
        CycledView(CycledView next) {
            this.next = next;

            createGUI();
        }

        abstract void createGUI();

        protected void callNext() {
            getScene().setRoot(next);
        }

        private CycledView next;
    }

    // Here you implement diffent GUIs for A, B and C
    private class A extends CycledView { 

        public A(CycledView next) {
            super(next);
        }

        void createGUI() {
            getChildren().add(new Button("I'm A") {
                @Override
                public void fire() {
                    callNext();
                }

            });
        }

    }

    private class B extends CycledView { 

        public B(CycledView next) {
            super(next);
        }

        void createGUI() {
            getChildren().add(new Button("This is B") {
                @Override
                public void fire() {
                    callNext();
                }

            });
        }

    }

    private class C extends CycledView { 

        public C(CycledView next) {
            super(next);
        }

        void createGUI() {
            getChildren().add(new Button("Greeting from C") {
                @Override
                public void fire() {
                    callNext();
                }

            });
        }

    }


    @Override
    public void start(Stage primaryStage) {

        CycledView c = new C(null);
        CycledView b = new B(c);
        CycledView a = new A(b);
        c.next = a;

        Scene scene = new Scene(a, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}