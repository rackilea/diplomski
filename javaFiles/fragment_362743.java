CountSum newVal = new CountSum(0, 0);
CountSum old;
do {
   old = countSumRef.get();
   // we need to loop here if someone changed the value behind our back
} while (!countSumRef.compareAndSet(old, newVal));
// now you can display the old value and be sure you got everything