Mockito.verify(drawingUtil).drawTextOnCanvas(
        Matchers.eq(imageCategory.getWidth()),      // A1
        Matchers.eq(mockGraphics),                  // A2
        Matchers.any(Font.class),                   // A3
        Matchers.eq(Arrays.asList("Test text")),    // A4
        Matchers.eq(testImage.getHeight() + 10),    // B
        Matchers.any(FontMetrics.class),            // C1
        Matchers.eq(10));                           // C2