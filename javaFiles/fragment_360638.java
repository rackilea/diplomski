public class NewFXMain extends Application {
        Stage window;
        Button b1;
        @Override
        public void start(Stage MainEvent)  {
           window=MainEvent;
           window.setTitle("hello");
           b1=new Button("click");
           b1.setOnAction(e -> AlertBox.display("hello", "welcome"));

           StackPane stk= new StackPane();
           stk.getChildren().add(b1);
           Scene sc= new Scene(stk,300,300);
           window.setScene(sc);
           window.show();                      
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            launch(args);
        }
       static  public class AlertBox {
         public  static void display(String title, String message) {
             Stage window= new Stage();
             window.initModality(Modality.APPLICATION_MODAL);
             window.setTitle(title);
             window.setMaxWidth(250);
             Label label1=new Label("hello");
             Button b1= new Button("close");
             b1.setOnAction(e -> window.close());
             VBox vb=new VBox();
             vb.getChildren().addAll(label1,b1);
             vb.setAlignment(Pos.CENTER);

             Scene sc= new Scene(vb,300,300);

             window.setScene(sc);

             window.show();
        }
    }
    }