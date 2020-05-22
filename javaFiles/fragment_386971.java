/**
     * PROS:
     * -Very low memory-footprint, as no new objects are created in memory, just references to a single (original) object.
     * -Can be done with generalization; A single method will function for most classes and data-types, as is below.
     * 
     * CONS:
     * -If you need each clone element to be changed independently from eachother and/or the orininal, this will not work directly,
     * because any change to an reference-element will apply to all other reference-elements that point to that same Object.
     * 
     * @param <E> Sub-class generalizator. Used so that the returned list has the same sub-class as the source.
     * @param list Source list. The list containing the elements to be interleaved.
     * @param f The factor to interleave for. In effect, the number of resulting elements for each original.
     * @return A list containing the interleaved elements, with each element being a REFERENCE to the original object.
     */
    public static <E> List<E> interleaveByReference(List<E> list, int f) {
        List<E> interleaved = new ArrayList<E>(list.size() * f);
        for (E obj : list) {
            for (int i = 0; i < f; i++) {
                interleaved.add(obj);
            }
        }
        return interleaved;
    }