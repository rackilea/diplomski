int stk[100];
int p = 0; // stack pointer

void list(void) {
  int i;
 start:
  if (len == total_count) printf("%.*s\n", total_count, str);
  for (i = 0; i < n_counts; i++) {
    if (counts[i] > 0) {
      str[len] = 'a' + i;
      --counts[i];
      ++len;
      stk[p++] = i;  // push i on stack
      goto start;
     rtn:
      --len;
      ++counts[i];
    }
  }
  // epilog
  if (p > 0) {
    i = stk[--p];  // restore i from stack
    goto rtn;
  }
}