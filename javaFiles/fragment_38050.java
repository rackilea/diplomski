Set<Integer> uniqueNumbers = new HashSet<Integer>();
Random r = new Random();
while(uniqueNumbers.size() < numRequired) {
    uniqueNumbers.add(r.nextInt(maxRandom) + 1);
} 
return uniqueNumbers.toArray(new Integer[0]);