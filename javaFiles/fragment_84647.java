List<Object> oldRec = new ArrayList<Object>();
for (Object obj : oldList) {
    if (! newList.contains(obj)) {
        oldRec.add(obj);
    }
}