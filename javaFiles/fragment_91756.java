// by iterator:
    int index=0;
    Iterator<BigInteger> iterator = fiboSequence.iterator(); 
    while(index++<10){
        System.out.println(iterator.next());
    }