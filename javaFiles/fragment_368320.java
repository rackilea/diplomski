public class ConfidanceComparator implements Comparator<ExpandedTerm> {
        @Override
        public int compare(final ExpandedTerm  o1, final ExpandedTerm  o2) {
            return new Double(o1.confidence).compareTo(new Double(o2.confidence));
        }
    }