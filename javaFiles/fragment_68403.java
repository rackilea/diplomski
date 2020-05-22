import java.util.*;
class ParserCacheManager {

    private Set<Parser<?>> parsers = new HashSet<Parser<?>>();

    public void addParser(Parser<?> p) { parsers.add(p); }

    public int size() {
        int size = 0;
        for(Parser<?> p : parsers) size += p.cacheSize();
        return size;
    }

    public void trimToSize(int maxSize) {
        while(size() > maxSize) {
            Parser<?> p = largestParser();
            p.trimToPercent(0.90);
        }
    }

    /**
     * This would be better perhaps with a set sorted by
     * size, or something like that. But this works for example.
     */
    private Parser<?> largestParser() {
        Parser<?> largest = null;
        for(Parser<?> p : parsers) {
            if(largest == null || p.size() > largest.size())
                largest = p;
        }
        return largest;
    }

}