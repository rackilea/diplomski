@Override
public Integer next() throws NoSuchElementException {

  if (index <= maxPow){ 
    index++;
    currentResult *= base;        
    return currentResult; 
  }
  else {   
    throw new NoSuchElementException();        
  }
}