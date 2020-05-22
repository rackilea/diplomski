PowerMockito.mockStatic(ImageIO.class);

when(ImageIO.read(any())).thenAnswer(invocation -> {
    Object argument = invocation.getArguments()[0];
    // here you can check what arguments you were passed

    BufferedImage result = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB); // create a BufferedImage object
    // here you can fill in some data so the image isn't blank

    return result;
});