for (Edges e: Edge){
    if (n.equals(e.start)||n.equals(e.end)){
        degree++;
        DegreeList.put(degree,n); // this shouldn't be here
    }
}
// instead, it belongs here