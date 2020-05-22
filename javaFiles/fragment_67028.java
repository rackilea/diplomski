public interface Thing extends Comparable<Thing>{

    int getVolume();

    //provide default method to sort any class which implements Thing
    @Override
    public default int compareTo(Thing another) {
        return Integer.compare(this.getVolume(), another.getVolume());
    }
}