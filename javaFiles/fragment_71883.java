Set<Entry<String,Integer>> set = dictionary.entrySet();

Iterator<Entry<String,Integer>> entryItr = set.iterator();

Entry<String,Integer> entry = null;

while(entryItr.hasnext()){
entry = entryItr.next();
// Do whatever you want.
}