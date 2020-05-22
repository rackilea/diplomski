for (Parent par: parents) {
    try {
        System.out.println(par.overridenMethod());
    } catch (NullPointerException npe) {
        System.out.println("No child at position: " + i);
    }
}