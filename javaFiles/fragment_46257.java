class Y {
    @Override
    public Y clone() {
        // Don't call super.clone() because it will error
        return new Y(...); // whatever parameters
    }
}