private void shuffle(){
    for(int i=0;i<N;i++){
        int j=StdRandom.uniform(0, i);
        exchange(i,j);
    }
}