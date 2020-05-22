List<String> bigList = new List<String>(); // put many many values in this list
String pattern = "pattern";      
long start = System.nanoTime();

for(int i=0;i<bigList.length;i++) {
   bigList.get(i).equals(pattern); //in another program, check for matches(pattern)
}

long end = System.nanoTime();

System.out.println((end-start)/bigList.size()) // this is the average time