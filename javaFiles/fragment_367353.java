int minNum = 0;
long maxFreq = 0;
for (Entry<Integer, Long> e : freqs.entrySet()) {
  if (e.getValue() > maxFreq) {
    minNum = e.getKey();
    maxFreq = e.getValue();
  } else if (e.getValue() == maxFreq) {
    minNum = Math.min(minNum, e.getKey());
  }
}
return minNum;