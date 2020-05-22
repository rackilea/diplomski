YourButtonWidget w1 = new YourButtonWidget("Some long label");
w1.addStyleNames("yourWidget"):
YourButtonWidget w2 = new YourButtonWidget("Label");
w2.addStyleNames("yourWidget"):
YourButtonWidget w3 = new YourButtonWidget("Another Label");
w3.addStyleNames("yourWidget"):

FlowPanel container = new FlowPanel();
container.add(w1);
container.add(w2);
container.add(w3);