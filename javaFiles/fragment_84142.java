public int hash(String key) 
   {
        int hashkey = key.hashCode();

        return hashkey % arraySize;
   }