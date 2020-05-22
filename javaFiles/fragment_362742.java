CountSum newVal = new CountSum();
do {
   CountSum old = countSumRef.get();
   newVal.setCount(old.getCount() + 1);
   newVal.setSum(old.getSum() + requestDataSize);
   // we need to loop here if someone changed the value behind our back
} while (!countSumRef.compareAndSet(old, newVal));