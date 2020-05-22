@Override
     protected boolean lessThan(final Entry hitA, final Entry hitB) {

         assert hitA != hitB;
         assert hitA.slot != hitB.slot;

         int numComparators = comparators.length;
         for (int i = 0; i < numComparators; ++i) {
             final int c = reverseMul[i] * comparators[i].compare(hitA.slot,
         hitB.slot);
         if (c != 0) {
         // Short circuit
         return c > 0;
         }
     }

     // avoid random sort order that could lead to duplicates (bug
     #31241):
     return hitA.doc > hitB.doc;
    }