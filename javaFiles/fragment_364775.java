int length = bitmap.getWidth()*bitmap.getHeight();
int[] array = new int[length];
bitmap.getPixels(array,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());
for (int i=0;i<length;i++){
// If the bitmap is in ARGB_8888 format
  if (array[i] == 0xff000000){
    array[i] = 0xffffffff;
  } else if ...
  }
}
bitmap.setPixels(array,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());