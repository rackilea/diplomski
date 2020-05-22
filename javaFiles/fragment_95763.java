void someMethod() {
    {
         int x = 1;
    }
    // no x defined here
    {
         // no x here, so we may define a new one
         string x = "Hello";
    }
}