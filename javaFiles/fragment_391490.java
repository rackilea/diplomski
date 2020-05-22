ArrayList<String> A = new ArrayList<String>();
ArrayList<String> B = new ArrayList<String>();
ArrayList<String> C;

Set<String> setA = new HashSet<String>(A);
Set<String> setB = new HashSet<String>(B);
setA.removeAll(setB);

c = new ArrayList<String>(setA);