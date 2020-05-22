/**
 * modifies the passed-in array to make sure only
 * the selected index is set to true
 */
void lightUp(boolean[] bs, int index) {
   for (int i=0; i<bs.length; i++) bs[i] = false;
   bs[index] = true;
}