public class PreferenceFieldComparatorSource<T> extends FieldComparatorSource {

    private static final long serialVersionUID = -8959374194451783596L;

    private final List<?> preferred;
    private final Class<?> clazz;
    private final TwoWayStringBridge stringBridge;

    @SafeVarargs
    public PreferenceFieldComparatorSource(Class<T> clazz,
            TwoWayStringBridge stringBridge, T... preferred) {
        this(clazz, stringBridge, Arrays.asList(preferred));
    }

    public PreferenceFieldComparatorSource(Class<T> clazz,
            TwoWayStringBridge stringBridge, List<T> preferred) {
        this.clazz = clazz;
        this.stringBridge = stringBridge;
        this.preferred = preferred;
    }

    @Override
    public FieldComparator<String> newComparator(final String fieldName,
            int numHits, int sortPos, final boolean reversed)
            throws IOException {
        return new FieldComparator<String>() {

            private String[] values;
            private String bottom;
            private String[] currentReaderValues;

            @Override
            public int compare(int slot1, int slot2) {
                return this.compare(this.values[slot1], this.values[slot2]);
            }

            @Override
            public int compareBottom(int doc) throws IOException {
                return this.compare(this.bottom, this.currentReaderValues[doc]);
            }

            @Override
            public void copy(int slot, int doc) throws IOException {
                this.values[slot] = this.currentReaderValues[doc];
            }

            @Override
            public void setBottom(int slot) {
                this.bottom = this.values[slot];
            }

            @Override
            public void setNextReader(IndexReader reader, int docBase)
                    throws IOException {                
                this.currentReaderValues = new String[reader.maxDoc()];
                this.values = new String[reader.maxDoc()];
                for (int i = 0; i < currentReaderValues.length; ++i) {
                    try {
                        this.currentReaderValues[i] = reader.document(i)
                                .get(fieldName);
                    } catch (ClassCastException e) {
                        throw new IllegalArgumentException(
                                PreferenceFieldComparatorSource.this.stringBridge
                                        + " doesn't convert strings into "
                                        + PreferenceFieldComparatorSource.this.clazz);
                    }
                }
            }

            @Override
            public String value(int slot) {
                return this.values[slot];
            }

            private int compare(Object first, Object second) {
                int firstIndex = PreferenceFieldComparatorSource.this.preferred
                        .indexOf(PreferenceFieldComparatorSource.this.stringBridge
                                .stringToObject((String) first));
                int secondIndex = PreferenceFieldComparatorSource.this.preferred
                        .indexOf(PreferenceFieldComparatorSource.this.stringBridge
                                .stringToObject((String) second));
                int result;
                if(firstIndex == -1 || secondIndex == -1) {
                    if(firstIndex == secondIndex) {
                        result = 0;
                    } else if(firstIndex == -1) {
                        result = 1;
                    } else {
                        result = -1;
                    }
                } else {
                    result = Integer.compare(firstIndex, secondIndex);
                }
                if (reversed) {
                    result *= -1;
                }
                return result;
            }

        };
    }

}