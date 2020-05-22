int bigger = Math.max(a, b);
int biggest = Math.max(bigger, c);
int smaller = Math.min(bigger, c);
int middle, smallest;
if (smaller >= bigger) {
    middle = smaller;
    smallest = Math.min(a, b);
} else {
    middle = Math.min(a, b);
    smallest = smaller;
}