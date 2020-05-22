List<Records> recs = new ArrayList<> ();
 recs.add (new Records (Arrays.asList ("a","b"), Arrays.asList (1,2), Arrays.asList (1.1,4.4)));
 recs.add (new Records (Arrays.asList ("c","d"), Arrays.asList (4,3), Arrays.asList (-3.3,135.3)));
 List<String> allStrings = getAllOccurrencesForType(Records::getListOfType1,recs);
 List<Integer> allIntegers = getAllOccurrencesForType(Records::getListOfType2,recs);
 List<Double> allDoubles = getAllOccurrencesForType(Records::getListOfType3,recs);
 System.out.println (allStrings);
 System.out.println (allIntegers);
 System.out.println (allDoubles);