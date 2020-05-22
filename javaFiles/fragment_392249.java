Iterator<ArrayList<ArrayList<String>>> iter = ar3.iterator();
while(iter.hasNext()){
    if(isSame(ar1, iter.next())){
        iter.remove();
    }
}