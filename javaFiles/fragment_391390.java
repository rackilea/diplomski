Set<Set<Integer>> storage = new HashSet<>();

public void doSomething() {
     // loop or do something interesting.
     storage.add(getNextGeneratedSet());
}

public Set<Integer> getNextGeneratedSet() {
     Set<Integer> result = new HashSet<>();
     for(int i : getNextRandomInt()) {
         result.add(i);
     }
     return result;
}