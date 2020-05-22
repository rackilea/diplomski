ArrayList<ArrayList<String>> allChains = new ArrayList<>();
allChains.add (new ArrayList<String>(Arrays.asList ("apple", "b", "c")));
allChains.add (new ArrayList<String>(Arrays.asList ("a")));
allChains.add (new ArrayList<String>(Arrays.asList ("a","b","c","d")));

ArrayList<String> longest = allChains.stream()
                                     .max(Comparator.comparingInt(ArrayList::size))
                                     .get();

System.out.println (longest);