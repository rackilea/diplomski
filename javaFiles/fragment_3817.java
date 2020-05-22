Transform3D t1 = ..., t2 = ..., t3 = ...;
// first do t1, then t2, then t3
Transform3D all = new Transform3D(); // all = identity
all.mul(t1, all); // all = t1 * all
all.mul(t2, all); // all = t2 * all
all.mul(t3, all); // all = t3 * all
// now all == t3 * t2 * t1