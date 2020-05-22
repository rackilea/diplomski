int totalCount = 0;

for (int i = 0; i < 10; i ++) {

  while (retry) {
    totalCount ++;
    // do your thing
  }
}

System.out.println("Took " + totalCount + " attempts to get 10 successfully");