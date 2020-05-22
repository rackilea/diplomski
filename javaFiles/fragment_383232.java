char map[5][5] = {
      {'.', '.', '.', '.', '.'}, 
      {'.', '.', '.', '.', '.'},
      {'.', '.', 'G', '.', '.'},
      {'.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.'} };

JNIEXPORT void JNICALL Java_MapJNI_replaceTile(
    JNIEnv *env, jobject jObject, jint x, jint y, jchar tile){
  char tileChar = (char)tile;
  map[y][x] = tileChar;
}