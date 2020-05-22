void raiseFlag() {
   if (memoryBarrier == true)
     throw new IllegalStateException("Flag already raised");
   memoryBarrier = true;
}

public int read(int index) {
  if (memoryBarrier == false)
     throw IllegalStateException("Flag not raised yet");
  return integers[index];
}