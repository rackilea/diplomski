private static <T> 
List<T> sampleFromPopulation(Set<T> population
                                , int sampleSize
                                , boolean exactSize) {
    int popSize = population.size();
    double sampleProb = ((double) sampleSize) / popSize;

    final double    OVER_SAMPLING_MULIT = 1.2;
    if (exactSize) {
        /*
         * Oversampling to enhance of chance of getting enough
         * samples (if we then have too many, we will drop them 
         * later)
         */
        sampleProb = sampleProb * OVER_SAMPLING_MULIT;
    }
    List<T> sample = new LinkedList<>(); // linked list for fast removal
    Iterator<T> iter = population.iterator();
    while (iter.hasNext()) {
        T element = iter.next();
        if (random.nextFloat()<sampleProb) {
            /*
             * Lucky Draw!
             */
            sample.add(element);
        }
    }
    int samplesTooMany = sample.size() - sampleSize;
    if (!exactSize || samplesTooMany==0) {
        return sample;
    } else if (samplesTooMany>0) {
        Set<Integer> indexesToRemoveAsSet = new HashSet<>();
        for (int i=0; i<samplesTooMany; ) {
            int candidate = random.nextInt(sample.size());
            if (indexesToRemoveAsSet.add(candidate)) {
                /*
                 * add() returns true if candidate was not 
                 * previously in the set
                 */
                i++; // proceed to draw next index
            }
        }
        List<Integer> indexesToRemoveAsList 
            = new ArrayList<>(indexesToRemoveAsSet);
        Collections.sort(indexesToRemoveAsList
                , (i1, i2) -> i2.intValue() - i1.intValue()); // desc order  
        /*
         * Now we drop from the tail of the list
         */
        for (Integer index : indexesToRemoveAsList) {
            sample.remove((int) index); // remove by index (not by element)
        }
        return sample;
    } else { 
        /*
         * we were unluckly that we oversampling we still
         * get less samples than specified, so here we call
         * this very same method again recursively
         */
        return sampleFromPopulation(population, sampleSize, exactSize);
    }
}