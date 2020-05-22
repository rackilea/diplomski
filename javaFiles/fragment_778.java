if (expand) {
   for (int i = 0; i < size; i++) {
     for (int j = 0; j < size; j++) {
       add(synset[i], synset[j], false);
     }
   }
 } else {
   for (int i = 0; i < size; i++) {
     add(synset[i], synset[0], false);
   }
 }