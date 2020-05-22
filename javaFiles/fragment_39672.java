List<String> list = toVisit.get(depth); //I assume list is not null
for (Iterator<String> it = list.iterator(); it.hasNext();) {
    String s = it.next();
    it.remove();
    harvest(new URL(s),depth-1);
}