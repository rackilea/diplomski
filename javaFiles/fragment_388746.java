DomDifference compare(DOMElement a, DOMElement b) {
   if(a.isLeaf()) {
     return DomDiff(a, b)
   }
   foreach(child: a.children()) {
     otherChild = b.nextChild()
     result = compare(child, otherChild);
     if(!result.isEqual()) {
       return result;
     }
   }
   return DomDifference.nodesAreEqual;
}