Integer minNum = Integer.MAX_VALUE;
for(Integer i :  numbers){
    if(i < minNum) {
        minNum = i;
    }
}
System.out.println("Minimum Value is: " + minNum);