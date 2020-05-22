public boolean authenticity(int tries) throws yourException {
    if (tries <= 3) {
        // ...
    } else {
         throw new yourException("\nCard was blocked!");      
    }
}