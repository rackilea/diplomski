public class SupportComparator implements Comparator<ExpandedTerm> {
        @Override
        public int compare(final ExpandedTerm  o1, final ExpandedTerm  o2) {
            return new Double(o1.support).compareTo(new Double(o2.support));
        }
    }