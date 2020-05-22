void removeFirst(int newVal2) {
  int index = -1;
  for (int i = 0; i < count; i++) {
     if (index == -1 && newVal2 == list[i]) {
       // element found - save index
       index = i;
     }
     if (index != -1) {
        // this code handles after found case
        if (i == count-1) {
          // zero-out last element
          list[i] = 0;
          count--;
        }
        else {
          // shift value
          list[i] = list[i+1];
        }
     }
  }
}