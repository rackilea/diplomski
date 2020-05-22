private void m() {    
    try {
        m(); // recursively calling m() will throw a StackOverflowError
    } catch (Exception e) {
        // this block won't get executed, 
        // because StackOverflowError is not an Exception!
    }
}