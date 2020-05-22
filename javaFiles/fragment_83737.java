StringBuffer b = new StringBuffer();
boolean first = true;

for (var t : collectionType) {
   if (first) {
      first = false;
   }
   else {
      b.add(", ");
   }

   b.add(t.toString());  
}

// Aggregated printable values are now b.toString()