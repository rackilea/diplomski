final Rect[] r1 = new Rect[number_of_cubes];
for (int i = 0; i < number_of_cubes; i++) {
  final int targetIndex = i;
  new Thread(new Runnable() { public void run() {
    ...
    r1[targetIndex] = ...
  }}).start();