public static CarType get(int code) { 
   for(CarType s : values()) {
      if(s.id == code) return s;
   }
   return null;
}