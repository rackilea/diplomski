public Slide[] thisIsASlide (String[] slider) { 
    // create an slide array the same length as your incoming array
    Slide[] slides = new Slide[slider.length];
    for (int i = 0; i < slider.length; ++i) {
        // Add a slide at index i for each string at index i in the incoming array
        slides[i] = thisNewMethod(slider[i], 20, 20);
    }
    // return the created array
    return slides;
}