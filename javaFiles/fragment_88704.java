// Set the properties that are common to all objects.
final TextBuilder builder = TextBuilder.create()
    .x(50)
    .fill(Color.WHITE)
    .font(MY_DEFAULT_FONT);

// Use the builder to construct different objects that have the 
// properties set above as well as the additional ones set here.
final Text text1 = builder.text("Hello World!").y(50).build();
final Text text2 = builder.text("Goodbye World!").y(100).build();
final Text text3 = builder.text("JavaFX is fun!").y(150).build();