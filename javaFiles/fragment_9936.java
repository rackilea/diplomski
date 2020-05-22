int span(Tree t) {
   Tree tMin = t;
   while (tMin.left != null) {
      tMin = tMin.left;
   }

   Tree tMax = t;
   while (tMax.right != null) {
      tMax = tMax.right;
   }

   return tMax.key - tMin.key;
}