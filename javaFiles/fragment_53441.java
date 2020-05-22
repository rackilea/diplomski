VBox vbox = new VBox();
vbox.getChildren().add(webView);
if(vbox.isResizable()){
    System.out.println("It's Resizable!");
    vbox.resize(300,200);     //doesn't work!
}