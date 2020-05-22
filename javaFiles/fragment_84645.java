List<Object> newRec = new ArrayList<Object>();
for (Object obj : newList) {
    if (! oldList.contains(obj)) {
        newRec.add(obj);
    }
}