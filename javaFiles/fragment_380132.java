public Literal(Literal l) {
  // have to deep copy the array, otherwise both instances are sharing the reference
  this.args = Arrays.copyOf(l.args, l.args.length);

  // safe to just copy the reference, String is immutable
  this.s = l.s;
}