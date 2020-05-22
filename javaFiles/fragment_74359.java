Document document = Jsoup.connect("http://example.com/somescript")
    .data("text1", "yourText1Value") // Fill the first input field.
    .data("text2", "yourText2Value") // Fill the second input field.
    .data("hidden1", "hidden1value") // You need to keep it unmodified!
    .data("button1", "Submit")       // This way the server knows which button was pressed.
    .post();

// ...