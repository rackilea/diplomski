while (edgesIterator.hasNext()) {
    HashMap tmp = edgesIterator.next();
    tmpList.add(tmp.get("fromnode").toString());
    tmpList.add(tmp.get("tonode").toString());
    tmpList.add(tmp.get("distance").toString());
    String[] tmpStr = new String[tmpList.size()];
    returnArray.add(tmpList.toArray(tmpStr));
}