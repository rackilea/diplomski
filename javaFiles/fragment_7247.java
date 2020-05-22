HBox h = new HBox();
 Label l = new Label("Hello");
 h.getChildren().add(l);
 Scene s = new Scene(h);
 l.impl_processCSS(true);
 System.err.println(l.prefWidth(-1)+"/"+l.prefHeight(-1));