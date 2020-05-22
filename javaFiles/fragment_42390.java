public int compareTo( Resultat r ) {

      int compare = Double.compare(tid, r.tod);
      if (compare != 0)
         return compare;
      else
         return namn.compareTo(r.namn);
   }