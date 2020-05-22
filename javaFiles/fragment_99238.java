void list(void) {
  for (int i = 0;;) {
    while (i < n_counts && counts[i] == 0) i++;
    if (i < n_counts) {
      --counts[i];
      str[len] = 'a' + i;
      stk[p++] = i;
      if (++len == total_count) printf("%.*s\n", total_count, str);
      i = 0;
    } else if (p > 0) {
      i = stk[--p];
      --len;
      ++counts[i++];
    }
    else break;
  }
}