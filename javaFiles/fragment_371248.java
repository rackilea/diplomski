public class FhirJsonValueFilter {
    @Override
    public boolean equals(Object value) {
        return !getWillInclude(value);
    }

    /**
     * Returns true for an object that matched filter criteria (will be 
     * included) and false for those to omit from the response.
     */
    public boolean getWillInclude(Object value) {
        //Omit explicit null values
        if (null == value) {
            return false;
        }

        //Omit empty collections
        if (Collection.class.isAssignableFrom(value.getClass())) {
            return !((Collection) value).isEmpty();
        }

        //Omit empty maps
        if (Map.class.isAssignableFrom(value.getClass())) {
            return !((Map) value).isEmpty();
        }

        //Omit empty char sequences (Strings, etc.)
        if (CharSequence.class.isAssignableFrom(value.getClass())) {
            return ((CharSequence) value).length() > 0;
        }

        //Omit empty FHIR data represented by an object
        if (FhirTypeInterface.class.isAssignableFrom(value.getClass())) {
            return !((FhirTypeInterface) value).isEmpty();
        }

        //If we missed something, default to include it
        return true;
    }
}