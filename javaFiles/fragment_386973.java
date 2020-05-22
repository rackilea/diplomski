/**
     * PROS:
     * -Each element is an independent object, and can be set to independent values without much of an effort.
     * 
     * CONS:
     * -Each element has it's own allocated memory for it's values, thus having a much heavier memory footprint.
     * -Is constructor-dependent, and thus cannot be generalized as easily;
     * Each different expected class will probably need it's own method.
     * 
     * @param list Source list. The list containing the elements to be interleaved.
     * @param f The factor to interleave for. In effect, the number of resulting elements for each original.
     * @return A list containing the interleaved elements.
     * For each of the original elements, the first is a REFERENCE, and the other are CLONES.
     */
    public static List<String> interleaveByClone(List<String> list, int f) {
        List<String> interleaved = new ArrayList<String>(list.size() * f);
        for (String obj : list) {
            interleaved.add(obj); //The first element doesn't have to be cloned, I assume.
            //If it has to be cloned, delete the line above, and change 'i=1' to 'i=0' on the line below.
            for (int i = 1; i < f; i++) {
                interleaved.add(new String(obj));
            }
        }
        return interleaved;
    }

    /*
     * What was changed from the original is commented below.
     */

    public static List<String> original(List<String> original, int factor) {
        /*
         * It is unnessessary to have this 'newSize' variable. It gets needlessly maintained until the end of the method.
         * Although the impact is unworthy of measurement (negligible), it still exists.
         */
        int newSize = original.size() * factor;
        List<String> interleaved = new ArrayList<String>(newSize); //Just do the '*factor' operarion directly, instead of 'newSize'.

        for (String foo : original) {
            /*
             * If you can use the original here, that's one less cloning operation (memory-allocation, etc...) per original element.
             * A low-impact optimization, but still a good one.
             */
            for (int j = 0; j < factor; j++) {
                interleaved.add(new String(foo));
            }
        }
        return interleaved;
    }