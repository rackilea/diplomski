Text text1=new Text("This is ");
text1.setStyle("-fx-font-size: 16px; -fx-fill: blue;");
Text text2=new Text("underlined ");
text2.setStyle("-fx-font-size: 16px; -fx-fill: blue; -fx-underline: true;");
Text text3=new Text("text");
text3.setStyle("-fx-font-size: 16px; -fx-fill: blue;");

TextFlow flow = new TextFlow(text1,text2,text3);

dialogPane.setContent(flow);