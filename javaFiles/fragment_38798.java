while (a < 1000) {
  if ((a + 1) % 3 == 0 || (a + 1) % 5 == 0) { 
    x += a;
  } else { 
    x += a + 1;
  }
  if (a == 1000) {
    break;
  }
  System.out.println(x);
  a++;
}