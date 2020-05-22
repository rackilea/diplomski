public static int count11(long n) {
  int cnt = 0;
  while (n != 0) {
    switch ((int)(n & 0x3F)) {
    case 0x3F: cnt += 3; break;
    case 0x3C: case 0x33: case 0xF: cnt += 2; break;
    case 0x30: case 0xC: case 3: cnt++;
    }
    n >>>= 6;
  }
  return cnt;
}