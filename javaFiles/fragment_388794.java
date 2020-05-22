long startTime = System.currentTimeMillis();
long tenSecondsFromStart = startTime + 10*1000;
long eightSecondsFromStart = startTime + 8*1000;
long sixSecondsFromStart = startTime + 6*1000;


while(System.currentTimeMillis() < sixSecondsFromStart){
   System.out.println("Hello");
}

while(System.currentTimeMillis() < eightSecondsFromStart){
   System.out.println("Goodbye");
}

while(System.currentTimeMillis() < tenSecondsFromStart){
   System.out.println("Hello again");
}