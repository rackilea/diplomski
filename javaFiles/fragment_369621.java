class Whatever {
 public:
  int x;
  void take(int n);
};

class T {
  public:
   int x;
};

void Whatever::take(int n) {
  T t;
  T *pt = &t; // pointer
  T &tr = t;  // reference is basically just an alias

  pt->x   = n;
  (*pt).x = n; // can dereference a pointer, then use like a reference
  tr.x    = n;

  // Same for this.
  this->x   = n;
  (*this).x = n;
}