import 'dart:math';

int chopToJavaInt (int result) {
  while (result > pow(2, 31)) {
    result = result - pow(2, 32);
  }
  return result;
}

int javaIntColor(int r, int g, int b) {
  var x = (g << 24) | (r << 16) | (g << 8) | b;
  return chopToJavaInt(x);
}

void main () {
  print(javaIntColor(154, 255, 147)); //-6619245
}