Collections.sort(your_list, new Comparator<YoureValueType>(){
   @Override
   public int compare(YoureValueType o1, YoureValueType o2){
        if(o1.getMagicInt() < o2.getMagicInt()){
           return -1; 
        }
        if(o1.getMagicInt() > o2.getMagicInt()){
           return 1; 
        }
        return 0;
   }
});