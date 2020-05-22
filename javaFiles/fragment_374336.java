if (paramType[i] == Integer.class) {
   Integer parInt = Integer.valueOf(params[i]); // params[i] is a String
   params[i] = parInt; // params[i] is now an Integer
}
else if (paramType[i] == String.class) {
   // 
}
else if ...