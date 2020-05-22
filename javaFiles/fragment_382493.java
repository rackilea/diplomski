if(Arrays.asList(text).contains(words[i]) && !Arrays.asList(uniqueWordArray).contains(words[i])) { 
    int x = (int)(Math.random()*211);
    uniqueWordArray[x] = words[i];
    z++; // see uWACount value
}
else {
    z++;
}