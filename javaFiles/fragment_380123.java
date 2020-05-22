private Set<String> one;
private Set<String> two;

public void run(){
    for(Iterator<String> iterOne=one.iterator(),Iterator<String> iterTwo=two.iterator(); iterOne.hasNext()&&iterTwo.hasNext();){
       // do something with iterOne.next() and iterTwo.next()
    }
}