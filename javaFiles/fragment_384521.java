public static void lengthFrequency (String [] words) {
int [] lengthTimes = new int [9];

for(int i = 0; i < words.length; i++) {
    String w = words[i];
    if(null!=w) //This one added for null check
    {
  /*  if(w.length() >= 10) {
    lengthTimes[9]++;
    } else {    
    lengthTimes[w.length()-1]++;
    }
    }*/