class TweakedHashSet<T> extends LinkedHashSet<T> {

    @Override
    public boolean add(T e) {
        // Get rid of old one.
        boolean wasThere = remove(e);
        // Add it.
        super.add(e);
        // Contract is "true if this set did not already contain the specified element"
        return !wasThere;
    }

}