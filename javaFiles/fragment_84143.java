public int hash(String key) 
   {
        int hashkey = key.hashCode();

        return (hashkey & 0x7FFFFFFF) % arraySize;
   }