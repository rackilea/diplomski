final TextBuilder builder = TextBuilder.create()

final Text text1 = builder
    .text("Hello World!")
    .x(50).y(50)
    .fill(Color.WHITE)
    .font(MY_DEFAULT_FONT)
    .build();

final Text text2 = builder
    .text("Goodbye World!")
    .x(50).y(100)
    .fill(Color.WHITE)
    .font(MY_DEFAULT_FONT)
    .build();