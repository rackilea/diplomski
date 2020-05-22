@Test
public void headerElementsWhichAreInOrderAreValid() {
    String html = "<html><body><h1></h1><h2></h2><h3></h3><h4></h4><h5></h5><h6></h6></body></html>";

    validateHeaderElementOrdering(html);
}

@Test
public void headerElementsWhichAreNotInOrderAreInvalid() {
    String html = "<html><body><h1></h1><h3></h3><h2></h2><h4></h4><h5></h5><h6></h6></body></html>";

    try {
        validateHeaderElementOrdering(html);
        Assert.fail("Expected out of order header elements to be deemed invalid!");
    } catch (RuntimeException ex) {
        Assert.assertEquals("Header tags are out of order: h3 came after h1", ex.getMessage());
    }
}

@Test
public void headerElementsWhichAreNotCompleteAndInOrderAreInvalid() {
    String html = "<html><body><h2></h2><h4></h4><h5></h5></body></html>";

    try {
        validateHeaderElementOrdering(html);
        Assert.fail("Expected out of order header elements to be deemed invalid!");
    } catch (RuntimeException ex) {
        Assert.assertEquals("Header tags are out of order: h4 came after h2", ex.getMessage());
    }
}

@Test
public void willValidateEvenWhenThereIsASingleHeaderElement() {
    String html = "<html><body><h3></h3></body></html>";

    try {
        validateHeaderElementOrdering(html);
        Assert.fail("Expected out of order header elements to be deemed invalid!");
    } catch (RuntimeException ex) {
        Assert.assertEquals("Header tags are out of order, there's only one header tag and it is not h1!", ex.getMessage());
    }
}