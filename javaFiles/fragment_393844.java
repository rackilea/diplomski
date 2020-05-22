String word1, word2;
int numCommon = 0;
try {
    Scanner sc = new Scanner(new FileInputStream(file));
    Scanner sc2 = new Scanner(new FileInputStream(file2));
    while (sc.hasNext()) {
        word1 = sc.next();
        while(sc2.hasNext()){
           word2 = sc2.next();
           if(word2.equals(word1))
              numCommon++;
        }
    }
    return numCommon;
} catch (Exception e) {
    e.printStackTrace();
}
return 0;