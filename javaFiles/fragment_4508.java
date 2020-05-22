public String getString() {
  try {        
    aLock.lock();
    return aString;
  } finally {
    aLock.unlock();
  }
}

public void setString(s) {
  try {        
    aLock.lock();
    aString = s;
  } finally {
    aLock.unlock();
  }
}