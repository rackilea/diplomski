private static final Pattern PATTERN 
    = Pattern.compile("\\bSTRINGDECODE\\(('[^']*(?:''[^']*)*')\\)");

// in code:

PATTERN.matcher(theInput).replaceAll("e$1")