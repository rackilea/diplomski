final String r = (new Object() {
    public String toString() {
        // -> error: variable r might not have been initialized
        // (And in this case it is indeed *not* assigned!)
        return "Hello " + r + "!";
    }
}).toString();