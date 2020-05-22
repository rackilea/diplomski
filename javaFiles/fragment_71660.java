public <D extends BaseClass> boolean doIt(D[] target) {
    try {
        D newD = (D) (target.getClass().getComponentType().getConstructor(int.class).newInstance(8));
        target[0] = newD;

        // The following is optional, if we want to work with Collections internally
        List<D> l = new ArrayList<D>(Arrays.asList(target));
        l.add(newD);  


    } catch (Exception e) {
        e.printStackTrace();
    }
    return true;
}