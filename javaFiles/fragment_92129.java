/**
 * Pick some samples from a population
 * @param population
 * @param sampleSize - number of samples
 * @param exactSize - a boolean to control whether or not
 *   the returned sample list must be of the exact size as
 *   specified.
 * @return
 */
private static <T> 
List<T> sampleFromPopulation(Set<T> population
                                , int sampleSize
                                , boolean exactSize);