List<Integer> lstNumbers = new ArrayList<Integer>();
//fill the list of integers...
Set<Integer> setNumbers = new HashSet<Integer>(lstNumbers);
//the set will contain no duplicate values...
for (int t : setNumbers) {
    System.out.print(t+", ");
}