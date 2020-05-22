// Create the counter
Counter c = new Counter(0);

// The Text node
Text text_counter = new Text(c.counter.get());

// Bind textProperty() to c.counter, which is a StringProperty
// Any changes to the value of c.counter will be reflected on the
// text of your Text node
text_counter.textProperty().bind(c.counter);

System.out.println("Before change:");
System.out.println(String.format("Text: %s Counter: %s",
        text_counter.textProperty().get(),
c.counter.get()));

c.counter.set("10"); // Make a change

System.out.println("After change:");
System.out.println(String.format("Text: %s Counter: %s",
        text_counter.textProperty().get(),
c.counter.get()));