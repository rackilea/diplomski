const int size = 7; /* Size of the tree */

/* Given arrays */
int post_order[size] = { 3 , 1 , 2 , 5 , 6 , 7 , 4 };
int in_order[size] = { 3 , 2 , 1 , 4 , 5 , 7 , 6 };

/* Variables updated during recursion */
int min_sum = 99999999; /* not initialized */
int best_leaf = -1; /* not initialized */

/* Recursive descent */
/* prb = post-order range begin, irb = in-order range begin, etc. */
void min_sum_leaf(int acc, int prb, int irb, int len) {
  if (len == 0) return; /* empty subtree */
  if (len == 1) { /* leaf */
    int sum = acc + in_order[irb];
    if (sum<min_sum) { min_sum = sum; best_leaf = in_order[irb]; }
    return;
  }
  /* non-leaf */
  int subtree_root = post_order[prb + len - 1];
  /* find the size of the left subtree */
  int i;
  for (i=0;i<len;i++) {
    if (in_order[irb + i] == subtree_root) break;
  }
  /* Now i is the length of the left subtree, len - i - 1 of the right */
  min_sum_leaf(acc + subtree_root, prb, irb, i);
  min_sum_leaf(acc + subtree_root, prb + i, irb + i + 1, len - i - 1);
}

/* Driver */
int find_min_sum_leaf() {
  min_sum = 99999999; best_leaf = -1;
  min_sum_leaf(0, 0, 0, size);
  return best_leaf;
}