// Using anonymous class (Java 1.2+)
this.directory = new TreeMap<Name, Integer>(new Comparator<Name>() {
    @Override
    public int compare(Name n1, Name n2) {
        return n1.getFirstName().compareTo(n2.getFirstName());
    }
});