//Union 
List<Integer> c = new ArrayList<Integer>(a.size() + b.size());
addNoDups(c,a);
addNoDups(c,b);

private void addNoDups(List<Integer> toAddTo,List<Integer> iterateOver) {
    for(Integer num:iterateOver){
        if(toAddTo.indexOf(num) == -1) {
            toAddTo.add(num);
        }
    }
}

//intersection
List<Integer> c = new ArrayList<Integer> (a.size() > b.size() ?a.size():b.size());
c.addAll(a);
c.retainAll(b);

//difference a-b
List<Integer> c = new ArrayList<Integer> (a.size());
c.addAll(a);
c.removeAll(b);