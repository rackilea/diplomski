boolean firstOptionFail = false;

try{
   verify(first, times(1)).toString();
   verify(second, never()).toString();      
}catch (MockitoException e) {
    firstOptionFail = true;
}

if(firstOptionFail){
  verify(first, never()).toString();
  verify(second, times(1)).toString();
}